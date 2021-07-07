package com.assignment.service;

import com.assignment.entity.activity.Activity;
import com.assignment.entity.employee.humanresource.HumanResourceEmployee;
import com.assignment.entity.employee.humanresource.NormalHR;
import com.assignment.entity.patient.Patient;
import com.assignment.factory.ServicesFactory;
import com.assignment.observer.IHumanResourcesObserver;
import com.assignment.service.dao.PatientDAO;

import java.util.List;

public class HumanResourcesService extends AssignmentService implements IHumanResourcesObserver, ICapacityCheck {
    public static final String SERVICE_NAME = "HumanResourcesService";
    private final PatientDAO patientDAO = ServicesFactory.getService(PatientDAO.SERVICE_NAME);
    private HumanResourceEmployee humanResourceEmployee;

    @Override
    public void acknowledgeNewPatient(Patient patient) {
        //find a HR employee who will take care this activity
        this.patient = patient;
        assignActivity(new Activity(Activity.ACKNOWLEDGED_NEW_PATIENT));

    }

    @Override
    void findAssignee() {
        System.out.println("Searching for an available HR to take care this activity...");
    }

    @Override
    void validateAssignee() {
        List<NormalHR> normalHRList = employeeDAO.findAllNormalHR();

        for (NormalHR normalHR : normalHRList){
            humanResourceEmployee = normalHR;
            if (!isFullWithActivitiesADay()){
                break;
            } else {
                humanResourceEmployee = null;
            }
        }
    }

    @Override
    void assign(Patient patient) {
        System.out.println("I'm not a doctor nor nurse!");
    }

    @Override
    void assign(Activity activity) {
        if(humanResourceEmployee != null){
            patientDAO.addNewPatient(patient);
            activity.setEmployee(humanResourceEmployee);
            activityDAO.addActivity(activity);
            System.out.println("Human Resource acknowledged the new patient: \n" + patient);
            System.out.println("An activity is registered: " + activity);
        } else {
            System.out.println("There is not any available HR staff currently!!!!!!!!!!!");
        }

    }

    //TODO: Adapter pattern
    @Override
    public boolean isFullWithPatients() {
        return false;
    }

    @Override
    public boolean isFullWithActivitiesADay() {
        int numberOfActivitiesToday = activityDAO.activityCountByEmployeeId(humanResourceEmployee.getId());
        return numberOfActivitiesToday == 5;
    }
}
