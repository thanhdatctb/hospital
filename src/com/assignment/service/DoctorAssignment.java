package com.assignment.service;

import com.assignment.entity.activity.Activity;
import com.assignment.entity.employee.healthcare.Doctor;
import com.assignment.entity.patient.Patient;

public class DoctorAssignment extends AssignmentService implements ICapacityCheck {

    public static final String SERVICE_NAME = "DoctorAssignment";
    private Doctor doctor;
    private int doctorId;

    @Override
    public void findAssignee() {
        //find doctor
        System.out.println("Select doctor, input doctor id: ");
        doctorId = input.nextInt();
        doctor = employeeDAO.findDoctorById(doctorId);
    }

    @Override
    public void validateAssignee() {
        while(doctor == null || isFullWithPatients() || isFullWithActivitiesADay()){
            if (doctor == null){
                System.out.println("Not found doctor for id " + doctorId);
            } else if (isFullWithPatients()) {
                System.out.println("Doctor " + doctor.getName() + " is fulled with patients");
            } else if (isFullWithActivitiesADay()){
                System.out.println("Doctor " + doctor.getName() + " reaches the max number of activities (5) today");
            }

            System.out.println("Please select other doctor id: (-1 to add later)");
            int doctorId = input.nextInt();
            if(doctorId == -1) {
                System.out.println("Doctor will be assigned later");
                break;
            }
            doctor = employeeDAO.findDoctorById(doctorId);
        }
    }

    @Override
    public void assign(Patient patient) {
        if(doctor != null){
            doctor.addPatient(patient);
            patient.setDoctor(doctor);
            System.out.println("Found and assigned doctor: " + doctor);
        }
    }

    @Override
    void assign(Activity activity) {
        System.out.println("Not support method");
    }

    @Override
    public boolean isFullWithPatients() {
        return doctor.getPatientList().size() >= 5;
    }

    @Override
    public boolean isFullWithActivitiesADay() {
        return activityDAO.activityCountByEmployeeId(doctorId) == 5;
    }

}
