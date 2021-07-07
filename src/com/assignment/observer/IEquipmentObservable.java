package com.assignment.observer;

public interface IEquipmentObservable {
    void attach(IEquipmentObserver observer);
    void detach(IEquipmentObserver observer);
    void notifyObservers();
}
