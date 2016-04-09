package com.biomarkhealth.medli.interfaces;

import com.biomarkhealth.medli.models.DoseSuggestions;
import com.biomarkhealth.medli.models.MedSuggestions;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by cmac147 on 3/30/16.
 */
public interface MedCompleteInterface {


    @GET("spellingsuggestions.json")
    Call<MedSuggestions> getSuggestions(@Query("name") String word);

    @GET("drugs.json")
    Call<DoseSuggestions> getDoseSuggestions(@Query("name") String name);

}
