package com.assignment.service;

import com.assignment.entity.activity.Activity;
import com.assignment.entity.employee.healthcare.Nurse;
import com.assignment.entity.equipment.EquipmentType;
import com.assignment.entity.patient.Patient;
import com.assignment.observer.IEquipmentObservable;
import com.assignment.observer.IEquipmentObserver;

public class NurseAssignment extends AssignmentService implements ICapacityCheck, IEquipmentObservable {
    public static final String SERVICE_NAME = "NurseAssignment";
    private Nurse nurse;
    private int nurseId;
    private IEquipmentObserver equipmentObserver;

    @Override
    void findAssignee() {
        //find and assign nurse
        System.out.println("Select nurse, input nurse id: ");
        nurseId = input.nextInt();
        nurse = employeeDAO.findNurseById(nurseId);
    }

    @Override
    void validateAssignee() {
        while(nurse == null || isFullWithPatients()){
            if (nurse == null){
                System.out.println("Not found nurse for id " + nurseId);
            } else if (isFullWithPatients()) {
                System.out.println("Nurse " + nurse.getName() + " is fulled with patients");
            } else if (isFullWithActivitiesADay()){
                System.out.println("Nurse " + nurse.getName() + " reaches the max number of activities (5) today");
            }

            System.out.println("Please select other nurse id:  (-1 to add later)");
            nurseId = input.nextInt();
            if(nurseId == -1) {
                System.out.println("Nurse will be assigned later");
                break;
            }
            nurse = employeeDAO.findNurseById(nurseId);
        }
    }

    @Override
    void assign(Patient patient) {
        if(nurse != null){
            nurse.addPatient(patient);
            patient.setNurse(nurse);
            System.out.println("Found and assigned nurse: " + nurse);
            notifyObservers();
        }
    }

    @Override
    void assign(Activity activity) {
        System.out.println("Not supported method");
    }

    @Override
    public boolean isFullWithPatients() {
        return nurse.getPatientList().size() >= 10;
    }

    @Override
    public boolean isFullWithActivitiesADay() {
        return activityDAO.activityCountByEmployeeId(nurseId) == 5;
    }

    @Override
    public void attach(IEquipmentObserver observer) {
        this.equipmentObserver = observer;
    }

    @Override
    public void detach(IEquipmentObserver observer) {
        this.equipmentObserver = null;
    }

    @Override
    public void notifyObservers() {
        if(equipmentObserver != null){
            equipmentObserver.updateEquipmentsStatus(2, EquipmentType.HEALTHCARE, true);
        }
    }
}
