package com.assignment.service.dao;

import com.assignment.entity.patient.Patient;

public interface IPatientDAO {
    public void addNewPatient(Patient patient);
    public Patient findPatientById(int id);
    public void removePatient(Patient toBeRemoved);
}
