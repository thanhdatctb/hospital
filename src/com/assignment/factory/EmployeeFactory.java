package com.assignment.factory;

import com.assignment.entity.employee.Employee;
import com.assignment.entity.employee.healthcare.Doctor;
import com.assignment.entity.employee.healthcare.Nurse;
import com.assignment.entity.employee.healthcare.ServiceChief;
import com.assignment.entity.employee.healthcare.Staff;

public class EmployeeFactory {
    // factory method to create the corresponding sub-type of employee
    public static Employee createEmployee(String type, String name) {
        switch (type) {
            case "D":
                return new Doctor(name);
            case "N":
                return new Nurse(name);
            case "SC":
                return new ServiceChief(name);
            default:
                return null;
        }
    }

    public static Employee recruitEmployee(String type) {
        switch (type) {
            case "D":
                return new Doctor(null);
            case "N":
                return new Nurse(null);
            case "S":
                return new Staff(null);
            default:
                return null;
        }
    }
}
