package com.biomarkhealth.medli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.biomarkhealth.medli.runnables.VoidTask;
import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

/**
 * Created by cmac147 on 3/20/16.
 */
public class MedLiSplash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.medli_splash);

        checkAuthStatus();
    }

    private void checkAuthStatus() {
        new VoidTask() {

            boolean loggedIn = false;

            @Override
            protected Void doInBackground(Void... params) {

                loggedIn = true;
                //TODO
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                Intent intent;

                if (!loggedIn) {

                    intent = new Intent(MedLiSplash.this, OnboardingActivity.class);

                } else {
                    intent = new Intent(MedLiSplash.this, MedliMainActivity.class);
                }
                startActivity(intent);
                MedLiSplash.this.finish();
            }
        }.execute();
    }
}
