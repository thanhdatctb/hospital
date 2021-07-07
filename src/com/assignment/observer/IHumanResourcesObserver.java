package com.assignment.observer;

import com.assignment.entity.patient.Patient;

public interface IHumanResourcesObserver {
    void acknowledgeNewPatient(Patient patient);
}
