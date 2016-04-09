package com.biomarkhealth.medli.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.biomarkhealth.medli.models.aa.Patient;
import com.google.gson.annotations.Expose;

import java.util.Date;
import java.util.List;

/**
 * Created by cmac147 on 3/24/16.
 */
@Table(name = "Medications")
public class Medication extends Model {

    @Expose
    @Column(name = "name")
    public String name;

    @Expose
    @Column(name = "dose")
    public Dose dose;

    @Expose
    @Column(name = "schedule_type")
    public String scheduleType;

    @Expose
    @Column(name = "date_started")
    public Date dateStarted;

    @Expose
    @Column(name = "date_filled_last")
    public Date lastFilled;

    @Expose
    @Column(name = "doses_left")
    public int dosesLeft;

    @Expose
    @Column(name = "patient")
    public Patient patient;

    @Expose
    @Column(name = "medication_image_link")
    public String medicationImageLink;

    public Medication() {
        super();
    }

    public static List<Medication> getAllMedications() {
        return new Select()
                .from(Medication.class)
                .execute();
    }

}
