package com.biomarkhealth.medli.utils;

/**
 * Created by cmac147 on 3/24/16.
 */

import android.util.Log;

import com.biomarkhealth.medli.lib.Constants;

public class LogUtil {

    public static void log(String tag, String message) {
        if (!Constants.PRODUCTION && message != null) {
            if (message.length() > 4000) {
                Log.wtf(tag, message.substring(0, 4000));

                log(tag, message.substring(4000));
            } else {
                Log.wtf(tag, message);
            }
        }
    }
}