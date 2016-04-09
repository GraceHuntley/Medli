package com.biomarkhealth.medli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.biomarkhealth.medli.activities.AddNewMedActivity;
import com.biomarkhealth.medli.lib.Constants;
import com.biomarkhealth.medli.models.Dose;
import com.biomarkhealth.medli.models.Medication;
import com.biomarkhealth.medli.models.aa.Patient;
import com.biomarkhealth.medli.utils.LogUtil;
import com.biomarkhealth.medli.views.StatusIconView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.poliveira.parallaxrecyclerview.ParallaxRecyclerAdapter;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cmac147 on 3/20/16.
 */
public class MedliMainActivity extends Activity {

    @Bind(R.id.fab)
    ImageView fab;
    @Bind(R.id.add_med)
    ImageView addMed;
    @Bind(R.id.add_event)
    ImageView addEvent;
    private String TAG = "MedliMainActivitiy.java";

    @Bind(R.id.main_recyclerview)
    RecyclerView mainRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.medli_main_activity);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        setupViews();
    }

    private void setupViews() {

        populateSeedData();

        mainRecyclerview.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        mainRecyclerview.setLayoutManager(llm);

        final List<Medication> medList = Medication.getAllMedications();

        ParallaxRecyclerAdapter adapter = new ParallaxRecyclerAdapter(medList) {
            @Override
            public void onBindViewHolderImpl(RecyclerView.ViewHolder holder, ParallaxRecyclerAdapter parallaxRecyclerAdapter, int position) {
                ((MedViewHolder) holder).medName.setText(medList.get(position).name);
                Picasso.with(Application.getContext())
                        .load(medList.get(position).medicationImageLink)
                        .fit()
                        .into(((MedViewHolder) holder).medPhoto);
            }

            @Override
            public RecyclerView.ViewHolder onCreateViewHolderImpl(ViewGroup viewGroup, ParallaxRecyclerAdapter parallaxRecyclerAdapter, int i) {
                return new MedViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_list_item, viewGroup, false));
            }

            @Override
            public int getItemCountImpl(ParallaxRecyclerAdapter parallaxRecyclerAdapter) {
                return medList.size();
            }
        };

        mainRecyclerview.setAdapter(adapter);

        View header = LayoutInflater.from(this).inflate(R.layout.main_header_view, mainRecyclerview, false);
        adapter.setParallaxHeader(header, mainRecyclerview);

        StatusIconView daysDosesLeftIconView = (StatusIconView) header.findViewById(R.id.meds_left_image);
        daysDosesLeftIconView.defineSpecs(5, StatusIconView.DAY_DOSES_IMAGE);

        StatusIconView eventsIconView = (StatusIconView) header.findViewById(R.id.event_image);
        eventsIconView.defineSpecs(2, StatusIconView.EVENTS_TODAY_IMAGE);

        populateViews();
    }

    private void populateViews() {

        setupListeners();

    }

    private void setupListeners() {

        mainRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {

                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEvent.setVisibility(addEvent.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
                addMed.setVisibility(addMed.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });

        addMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedliMainActivity.this, AddNewMedActivity.class);

                startActivity(intent);
                MedliMainActivity.this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

    }

    private void populateSeedData() {

        if (Medication.getAllMedications().size() == 0) {
            for (int i = 0; i < 2; i++) {
                Patient patient = new Patient();
                patient.name = "Patient_" + i;
                patient.picture = "http://placehold.it/32x32";
                patient.save();

            }

            for (int i = 0; i < 10; i++) {
                Medication medication = new Medication();
                medication.name = "Medication_" + i;
                medication.dateStarted = new Date();
                Random random = new Random();
                Dose dose = new Dose(1, Dose.getRandomMeasureType(), (1 + random.nextInt(4)), (1 + random.nextInt(12)));
                dose.save();
                medication.dose = dose;
                medication.dosesLeft = 10;
                medication.lastFilled = new Date();
                medication.medicationImageLink = Constants.PLACEHOLDER_IMAGES[random.nextInt(Constants.PLACEHOLDER_IMAGES.length)];
                medication.scheduleType = "routine";
                medication.dose.maxDailyDose = 4;
                medication.dose.doseTimeInterval = 4;
                medication.patient = Patient.getRandomPatient();

                medication.save();

            }
        }

        List<Medication> medicationList = Medication.getAllMedications();

        for (int i = 0; i < medicationList.size(); i++) {
            Medication medication = medicationList.get(i);

            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
                    .setPrettyPrinting()
                    .create();
            String json = gson.toJson(medication);
            //LogUtil.log(TAG, medication.patient.name);
            LogUtil.log(TAG, json);
        }

    }

    public static class MedViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView medName;
        ImageView medPhoto;

        MedViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            medName = (TextView) itemView.findViewById(R.id.med_name);
            medPhoto = (ImageView) itemView.findViewById(R.id.med_photo);
        }
    }
}
