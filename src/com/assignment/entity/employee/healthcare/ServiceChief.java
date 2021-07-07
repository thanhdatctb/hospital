package com.assignment.entity.employee.healthcare;

import com.assignment.entity.patient.Patient;

public class ServiceChief extends HealthcareEmployee{
    public ServiceChief(int id, String name) {
        super(id, name);
    }

    public ServiceChief(String name) {
        super(name);
    }

    @Override
    public void addPatient(Patient patient) {
        System.out.println("Service Chief does not take care directly the patients");
    }
}
