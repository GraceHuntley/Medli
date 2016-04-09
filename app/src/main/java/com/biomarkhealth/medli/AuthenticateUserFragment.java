package com.biomarkhealth.medli;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.biomarkhealth.medli.utils.LogUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cmac147 on 3/20/16.
 */
public class AuthenticateUserFragment extends Fragment {

    int type;
    @Bind(R.id.email_entry)
    EditText emailEntry;
    @Bind(R.id.password_entry)
    EditText passwordEntry;
    @Bind(R.id.password_confirm_entry)
    EditText passwordConfirmEntry;
    @Bind(R.id.sign_up_txt_button)
    TextView signUpTxtButton;
    @Bind(R.id.sign_in_txt_button)
    TextView signInTxtButton;
    private OnFragmentInteractionListener mListener;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.authenticate_user_activity, container, false);
        type = getArguments().getInt("type");
        ButterKnife.bind(this, rootView);
        setupViews();

        return rootView;
    }

    private void setupViews() {

        transitionViews();

        populateViews();
    }

    private void transitionViews() {

        passwordConfirmEntry.setVisibility(type == OnboardingActivity.SIGN_UP ? View.GONE : View.VISIBLE);
        signInTxtButton.setVisibility(type == OnboardingActivity.SIGN_UP ? View.GONE : View.VISIBLE);
        signUpTxtButton.setVisibility(type == OnboardingActivity.SIGN_IN ? View.GONE : View.VISIBLE);
    }

    private void populateViews() {

        signInTxtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.onFragmentInteraction(0);
            }
        });

        signUpTxtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.onFragmentInteraction(1);
            }
        });

    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        LogUtil.log("test", "test");
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(int command);
    }
}
