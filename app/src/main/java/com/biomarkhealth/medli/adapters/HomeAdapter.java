package com.biomarkhealth.medli.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.biomarkhealth.medli.Application;
import com.biomarkhealth.medli.R;
import com.biomarkhealth.medli.models.Medication;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by cmac147 on 3/24/16.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MedViewHolder> {

    List<Medication> medications;

    public HomeAdapter(List<Medication> medications) {
        this.medications = medications;
    }

    @Override
    public MedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_list_item, parent, false);
        MedViewHolder medViewHolder = new MedViewHolder(view);
        return medViewHolder;
    }

    @Override
    public void onBindViewHolder(MedViewHolder holder, int position) {
        holder.medName.setText(medications.get(position).name);
        Picasso.with(Application.getContext())
                .load(medications.get(position).medicationImageLink)
                .fit()
                .into(holder.medPhoto);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return medications.size();
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
