package com.assignment.entity.employee.healthcare;

import com.assignment.entity.patient.Patient;

public class Staff extends HealthcareEmployee {

    private static final int MAX_NUMBER_OF_PATIENTS = 5;

    public Staff(int id, String name) {
        super(id, name);
    }

    public Staff(String name) {
        super(name);
    }

    @Override
    public void addPatient(Patient patient) {
    }
}
