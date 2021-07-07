package com.assignment.stubdata;

import com.assignment.entity.patient.DiseaseType;
import com.assignment.entity.patient.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientStubData {

    public static List<Patient> patientList = new ArrayList<>();

    static {
        patientList.add(new Patient(1, "Tom", 30, DiseaseType.MEDICAL, false));
        patientList.add(new Patient(2, "Nicolai", 40, DiseaseType.MEDICAL, false));
        patientList.add(new Patient(3, "Mark", 50, DiseaseType.MEDICAL, false));
        patientList.add(new Patient(4, "Tony", 60, DiseaseType.MEDICAL, false));
        patientList.add(new Patient(5, "Daniel", 8, DiseaseType.MEDICAL, false));
    }
}
