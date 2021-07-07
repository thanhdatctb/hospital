package com.assignment.service;

/**
 * This is using Strategy Design Pattern to check if the doctor or nurse is fulled with patients
 */
public interface ICapacityCheck {
    boolean isFullWithPatients();
    boolean isFullWithActivitiesADay();
}
