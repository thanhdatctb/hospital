package com.assignment.service.dao;

import com.assignment.entity.patient.Patient;

public class PatientDAOProxy implements IPatientDAO{
    public static final String SERVICE_NAME = "PatientDAOProxy";
    private PatientDAO patientDAO = new PatientDAO();

    @Override
    public void addNewPatient(Patient patient) {
        patientDAO.addNewPatient(patient);
    }

    @Override
    public Patient findPatientById(int id) {
        return patientDAO.findPatientById(id);
    }

    @Override
    public void removePatient(Patient toBeRemoved) {
        patientDAO.removePatient(toBeRemoved);
    }
}
