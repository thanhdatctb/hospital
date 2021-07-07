package com.assignment.entity.employee.healthcare;

import com.assignment.entity.patient.Patient;

public class Nurse extends HealthcareEmployee{
    private static final int MAX_NUMBER_OF_PATIENTS = 10;

    public Nurse(int id, String name) {
        super(id, name);
    }

    public Nurse(String name) {
        super(name);
    }

    @Override
    public void addPatient(Patient patient) {
        if(this.patientList.size() == MAX_NUMBER_OF_PATIENTS ){
            System.out.println("A nurse can take care max 10 patients at a time");
        } else {
            super.addPatient(patient);
        }
    }
}
