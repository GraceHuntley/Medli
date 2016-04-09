package com.biomarkhealth.medli;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.biomarkhealth.medli.fragments.OnboardingFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cmac147 on 3/20/16.
 */
public class OnboardingActivity extends FragmentActivity implements AuthenticateUserFragment.OnFragmentInteractionListener {

    final static int SIGN_IN = 0;
    final static int SIGN_UP = 1;
    @Bind(R.id.sign_up_txt_button)
    TextView signUpTxtButton;
    @Bind(R.id.sign_in_txt_button)
    TextView signInTxtButton;
    @Bind(R.id.text_button_wrapper)
    LinearLayout textButtonWrapper;


    @Override
    public void onBackPressed() {

        if (getFragmentManager().getBackStackEntryCount() > 1) {
            getFragmentManager().popBackStackImmediate();
            textButtonWrapper.setVisibility(View.VISIBLE);
        } else
            super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.onboarding_activity);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        setupViews();
    }

    private void setupViews() {

        populateViews();
    }


    private void populateViews() {

        getFragmentManager().beginTransaction()
                .add(R.id.fragment_container, OnboardingFragment.newInstance())
                .addToBackStack("main")
                .commit();

        setupListeners();

    }

    private void setupListeners() {
        signInTxtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadAuthenticator(SIGN_IN);
            }
        });

        signUpTxtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadAuthenticator(SIGN_UP);
            }
        });
    }


    private void loadAuthenticator(int type) {

        textButtonWrapper.setVisibility(View.GONE);
        Fragment fragment = new AuthenticateUserFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        fragment.setArguments(bundle);
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack("auth")
                .commit();
    }

    @Override
    public void onFragmentInteraction(int command) {

        Intent intent = new Intent(this, MedliMainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
