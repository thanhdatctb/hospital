package com.assignment.entity.employee.healthcare;

import com.assignment.entity.employee.Employee;
import com.assignment.entity.patient.Patient;
import com.assignment.entity.service.Service;

import java.util.ArrayList;
import java.util.List;

public class HealthcareEmployee extends Employee {
    Service service;
    List<Patient> patientList = new ArrayList<>();

    public HealthcareEmployee(int id, String name) {
        super(id, name);
    }

    public HealthcareEmployee(String name) {
        super(name);
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void addPatient(Patient patient) {
        this.patientList.add(patient);
    }

    public Service getService() {
        return service;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }
}
