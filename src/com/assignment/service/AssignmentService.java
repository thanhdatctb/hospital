package com.assignment.service;

import com.assignment.entity.activity.Activity;
import com.assignment.entity.patient.Patient;
import com.assignment.factory.ServicesFactory;
import com.assignment.service.dao.ActivityDAO;
import com.assignment.service.dao.EmployeeDAO;

import java.util.Scanner;

/**
 * Using Template design pattern to assign the patient to doctor and nurse
 */
public abstract class AssignmentService {
    protected EmployeeDAO employeeDAO = ServicesFactory.getService(EmployeeDAO.SERVICE_NAME);
    protected ActivityDAO activityDAO = ServicesFactory.getService(ActivityDAO.SERVICE_NAME);
    protected Scanner input = new Scanner(System.in);
    protected Patient patient;
    protected Activity activity;

    abstract void findAssignee();
    abstract void validateAssignee();
    abstract void assign(Patient patient);
    abstract void assign(Activity activity);

    public AssignmentService() {
    }

    //template method
    public final void assignPatient(Patient patient){
        this.patient = patient;
        findAssignee();
        validateAssignee();
        assign(patient);
    }

    //template method
    public final void assignActivity(Activity activity){
        this.activity = activity;
        findAssignee();
        validateAssignee();
        assign(activity);
    }

}
