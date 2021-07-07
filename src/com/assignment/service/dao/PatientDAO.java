package com.assignment.service.dao;

import com.assignment.entity.patient.Patient;
import com.assignment.stubdata.PatientStubData;

import java.util.Iterator;

public class PatientDAO implements IPatientDAO{
    public static final String SERVICE_NAME = "PatientDAO";
    public void addNewPatient(Patient patient){
        int patientId = 1;
        if (!PatientStubData.patientList.isEmpty()){
            patientId = PatientStubData.patientList.get(PatientStubData.patientList.size()-1).getId() + 1;
        }
        patient.setId(patientId);
        PatientStubData.patientList.add(patient);
    }

    public Patient findPatientById(int id) {
        for (Patient patient : PatientStubData.patientList) {
            if(patient.getId() == id){
                return patient;
            }
        }
        return null;
    }

    public void removePatient(Patient toBeRemoved) {
        Iterator<Patient> patientItr = PatientStubData.patientList.iterator();
        while(patientItr.hasNext()){
            Patient patient = patientItr.next();
            if(patient.getId() == toBeRemoved.getId()){
                patientItr.remove();
            }
        }
        System.out.println("Removed a patient " + toBeRemoved);
    }
}
