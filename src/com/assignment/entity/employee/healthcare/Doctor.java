package com.assignment.entity.employee.healthcare;

import com.assignment.entity.patient.Patient;


public class Doctor extends  HealthcareEmployee{
    private static final int MAX_NUMBER_OF_PATIENTS = 5;

    public Doctor(int id, String name) {
        super(id, name);
    }

    public Doctor(String name) {
        super(name);
    }


    @Override
    public void addPatient(Patient patient) {
        if(this.patientList.size() == MAX_NUMBER_OF_PATIENTS ){
            System.out.println("A doctor can take care max 5 patients at a time");
        } else {
            super.addPatient(patient);
        }
    }
}
