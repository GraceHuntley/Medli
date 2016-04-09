package com.biomarkhealth.medli.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.biomarkhealth.medli.R;
import com.biomarkhealth.medli.adapters.DoseSuggestionAdapter;
import com.biomarkhealth.medli.interfaces.MedCompleteInterface;
import com.biomarkhealth.medli.lib.Constants;
import com.biomarkhealth.medli.models.DoseSuggestions;
import com.biomarkhealth.medli.models.MedSuggestions;
import com.biomarkhealth.medli.utils.LogUtil;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddNewMedActivity extends AppCompatActivity {

    final static String TAG = "AddNewMedActivity.java";

    Retrofit retrofit;
    MedCompleteInterface medCompleteInterface;
    @Bind(R.id.dose_selector)
    ListView doseSelector;
    private Call<MedSuggestions> suggestions;
    private Call<DoseSuggestions> doseSuggestions;
    private ArrayAdapter<String> adapter;
    private boolean lockTextEntry = false;

    @Bind(R.id.med_autocomplete_entry)
    AutoCompleteTextView medAutocompleteEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_med);
        ButterKnife.bind(this);

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.RXNAV_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        medCompleteInterface = retrofit.create(MedCompleteInterface.class);

        medAutocompleteEntry.setThreshold(2);

        setupListeners();
    }

    private void setupListeners() {
        medAutocompleteEntry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!lockTextEntry) {


                    if (suggestions != null && suggestions.isExecuted())
                        suggestions.cancel();

                    suggestions = medCompleteInterface.getSuggestions(s.toString());

                    suggestions.enqueue(new Callback<MedSuggestions>() {
                        @Override
                        public void onResponse(Call<MedSuggestions> call, Response<MedSuggestions> response) {
                            List<String> list = response.body().getSuggestionGroup().getSuggestionList().getSuggestion();
                            adapter = new ArrayAdapter<>(AddNewMedActivity.this,
                                    android.R.layout.select_dialog_item, list);


                            medAutocompleteEntry.setAdapter(adapter);
                            medAutocompleteEntry.showDropDown();

                        }

                        @Override
                        public void onFailure(Call<MedSuggestions> call, Throwable t) {
                            LogUtil.log(TAG, call.request().url().toString());
                        }
                    });

                } else {
                    medAutocompleteEntry.setDropDownHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
                    lockTextEntry = false;
                }

            }
        });

        medAutocompleteEntry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lockTextEntry = true;
                medAutocompleteEntry.setDropDownHeight(0);
                getDoseListFromNui(adapter.getItem(position));

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(medAutocompleteEntry.getWindowToken(), 0);

            }
        });
    }

    private void getDoseListFromNui(String rxcui) {

        doseSuggestions = medCompleteInterface.getDoseSuggestions(rxcui);

        doseSuggestions.enqueue(new Callback<DoseSuggestions>() {
            @Override
            public void onResponse(Call<DoseSuggestions> call, Response<DoseSuggestions> response) {
                if (response.body().getDrugGroup().getConceptGroup().size() > 0) {
                    DoseSuggestionAdapter adapter = new DoseSuggestionAdapter(AddNewMedActivity.this,
                            android.R.layout.simple_list_item_1, response.body().getDrugGroup().getConceptGroup().get(1).getConceptProperties());

                    doseSelector.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<DoseSuggestions> call, Throwable t) {
                LogUtil.log(TAG, "Failed dose suggestions.");
            }
        });


    }
}
