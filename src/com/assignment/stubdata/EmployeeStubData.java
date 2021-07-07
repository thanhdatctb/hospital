package com.assignment.stubdata;

import com.assignment.entity.employee.Employee;
import com.assignment.entity.employee.healthcare.Doctor;
import com.assignment.entity.employee.healthcare.Nurse;
import com.assignment.entity.employee.healthcare.ServiceChief;
import com.assignment.entity.employee.humanresource.Director;
import com.assignment.entity.employee.humanresource.NormalHR;
import com.assignment.entity.employee.staff.CleaningStaff;
import com.assignment.entity.employee.staff.InventoryStaff;
import com.assignment.entity.employee.staff.LaundryStaff;
import com.assignment.entity.employee.staff.Staff;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStubData {
    public static List<Doctor> doctorList = new ArrayList<>();
    public static List<Doctor> doctorListDraft = new ArrayList<>();
    public static List<Nurse> nurseList = new ArrayList<>();
    public static List<Nurse> nurseListDraft = new ArrayList<>();
    public static Director director = Director.getInstance("Phillip");
    public static List<Staff> staffList = new ArrayList<>();
    public static List<Staff> staffListDraft = new ArrayList<>();
    public static List<CleaningStaff> cleaningStaffList = new ArrayList<>();
    public static List<LaundryStaff> laundryStaffList = new ArrayList<>();
    public static List<InventoryStaff> inventoryStaffList = new ArrayList<>();
    public static List<NormalHR> normalHRList = new ArrayList<>();
    public static List<ServiceChief> serviceChiefList = new ArrayList<>();
    public static List<Employee> recruitEmployeeList = new ArrayList<>();

    static {
        //doctors
        Doctor david = new Doctor(1000, "David");
        doctorList.add(david);
        Doctor john = new Doctor(1001, "John");
        doctorList.add(john);
        Doctor kim = new Doctor(1002, "Kim");
        doctorList.add(kim);
        Doctor harry = new Doctor(1003, "Harry");
        doctorList.add(harry);

        ///nurses
        nurseList.add(new Nurse(1000, "Jane"));
        nurseList.add(new Nurse(1001, "Rose"));
        nurseList.add(new Nurse(1002, "Lona"));
        nurseList.add(new Nurse(1003, "Sia"));

        //staff
        cleaningStaffList.add(new CleaningStaff(1000, "Lauren"));
        inventoryStaffList.add(new InventoryStaff(1001, "John"));
        laundryStaffList.add(new LaundryStaff(1002, "Nina"));
        staffList.addAll(cleaningStaffList);
        staffList.addAll(inventoryStaffList);
        staffList.addAll(laundryStaffList);

        //HR
        normalHRList.add(new NormalHR(1000, "Thomas"));
        normalHRList.add(new NormalHR(1001, "Jenny"));
        normalHRList.add(new NormalHR(1002, "Babara"));
        normalHRList.add(new NormalHR(1003, "Micheal"));

        //Service Chief
        serviceChiefList.add(new ServiceChief(1000, "Nick"));
        serviceChiefList.add(new ServiceChief(1001, "Tommy"));
        serviceChiefList.add(new ServiceChief(1002, "Collin"));
        serviceChiefList.add(new ServiceChief(1003, "Fred"));
    }

}
