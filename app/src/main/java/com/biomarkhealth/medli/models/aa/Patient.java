package com.biomarkhealth.medli.models.aa;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.google.gson.annotations.Expose;

/**
 * Created by cmac147 on 3/24/16.
 */
@Table(name = "Patients")
public class Patient extends Model {

    @Expose
    @Column(name = "name")
    public String name;

    @Expose
    @Column(name = "picture")
    public String picture;

    public static Patient getRandomPatient() {
        return new Select()
                .from(Patient.class)
                .orderBy("RANDOM()")
                .executeSingle();
    }

}
