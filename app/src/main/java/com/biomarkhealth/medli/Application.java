package com.biomarkhealth.medli;

import android.content.Context;

/**
 * Created by cmac147 on 3/20/16.
 */
public class Application extends com.activeandroid.app.Application {

    private static Application instance;

    public Application() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static Context getContext() {
        return instance.getApplicationContext();
    }
}
