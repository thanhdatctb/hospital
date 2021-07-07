package com.assignment.entity.activity;

import com.assignment.entity.employee.Employee;

import java.util.Date;

public class Activity {
    public static final String CLEANING = "Cleaning";
    public static final String LAUNDRY = "Laundry";
    public static final String ACKNOWLEDGED_NEW_PATIENT = "Acknowledged_new_patient";


    int id;
    String name;
    Date date;
    Employee employee;

    public Activity(int id, String name, Date date, Employee employee) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.employee = employee;
    }

    public Activity(String name, Date date, Employee employee) {
        this.name = name;
        this.date = date;
        this.employee = employee;
    }

    /**
     * This constructor will initiate an activity in the current date
     * @param id
     * @param name
     * @param employee
     */
    public Activity(String name) {
        this(name, new Date(System.currentTimeMillis()), null);
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public String toString() {
        return "Activity: " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", Employee: {" + employee +
                "}";
    }
}
