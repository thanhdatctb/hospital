package com.assignment.observer;

import com.assignment.entity.patient.Patient;

public interface IHumanResourcesObservable {
    void attach(IHumanResourcesObserver observer);
    void notifyObserver(Patient patient);
}
