package com.biomarkhealth.medli.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.biomarkhealth.medli.R;

public class OnboardingFragment extends Fragment {

    public OnboardingFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        OnboardingFragment fragment = new OnboardingFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
