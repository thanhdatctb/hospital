package com.assignment.service;

import com.assignment.entity.activity.Activity;
import com.assignment.entity.employee.staff.Staff;
import com.assignment.entity.patient.Patient;

public class StaffAssignment extends AssignmentService implements ICapacityCheck{

    public static final String SERVICE_NAME = "StaffAssignment";
    private Staff staff;
    private int staffId;

    @Override
    void findAssignee() {
        System.out.println("Select the staff id: ");
        staffId = input.nextInt();
        staff = employeeDAO.findStaffById(staffId);
    }

    @Override
    void validateAssignee() {
        while(staff == null || isFullWithActivitiesADay()){
            if (staff == null){
                System.out.println("Not found staff for id " + staffId);
            } else if (isFullWithActivitiesADay()) {
                System.out.println("Staff " + staff.getName() + " reaches the max number of activities (5) today");
            }

            System.out.println("Please select other staff id: (-1 to exit)");
            staffId = input.nextInt();
            if(staffId == -1) {
                break;
            }
            staff = employeeDAO.findStaffById(staffId);
        }
    }

    //TODO: apply Adapter DP to get rid of this
    @Override
    void assign(Patient patient) {

    }

    @Override
    void assign(Activity activity) {
        if(staff != null){
            activity.setEmployee(staff);
            activityDAO.addActivity(activity);
            System.out.println("Reserved for performing activity: " + activity);
        }
    }

    @Override
    public boolean isFullWithPatients() {
        return false;
    }

    @Override
    public boolean isFullWithActivitiesADay() {
        return activityDAO.activityCountByEmployeeId(staffId) == 5;
    }
}
