package com.biomarkhealth.medli.models.aa;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;

/**
 * Created by cmac147 on 4/8/16.
 */
@Table(name = "medications")
public class Medication extends Model {

    @Expose
    @Column(name = "name")
    public String name;

    @Expose
    @Column(name = "dose")
    public double dose;

    @Expose
    @Column(name = "dose_type")
    public String doseType;

    


}
