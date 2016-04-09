package com.biomarkhealth.medli.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.biomarkhealth.medli.models.aa.Patient;
import com.biomarkhealth.medli.utils.LogUtil;
import com.google.gson.annotations.Expose;

import java.util.Random;

/**
 * Created by cmac147 on 3/24/16.
 */

@Table(name = "Doses")
public class Dose extends Model {

    public static String measureTypes[] = {"ml", "mg", "cc", "drops", "TBS", "tb"};
    private static final String TAG = "Dose.java";

    @Expose
    @Column(name = "measure")
    public int measure;

    @Expose
    @Column(name = "measure_type")
    public String measureType;

    @Expose
    @Column(name = "max_daily_dose")
    public int maxDailyDose;

    @Expose
    @Column(name = "dose_time_interval")
    public int doseTimeInterval;

    public static String getRandomMeasureType() {
        Random random = new Random();
        return measureTypes[random.nextInt(measureTypes.length)];
    }

    public Dose() {
        super();
    }


    public Dose(int measure, String measureType, int maxDailyDose, int doseTimeInterval) {
        super();
        this.measure = measure;
        this.measureType = measureType;
        this.maxDailyDose = maxDailyDose;
        this.doseTimeInterval = doseTimeInterval;

        LogUtil.log(TAG, "new dose");
    }

    public static Patient getRandomDose() {
        return new Select()
                .from(Dose.class)
                .orderBy("RANDOM()")
                .executeSingle();
    }
}