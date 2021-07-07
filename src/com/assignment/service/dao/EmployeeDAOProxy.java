package com.assignment.service.dao;

import com.assignment.entity.employee.Employee;
import com.assignment.entity.employee.healthcare.Doctor;
import com.assignment.entity.employee.healthcare.Nurse;
import com.assignment.entity.employee.healthcare.ServiceChief;
import com.assignment.entity.employee.humanresource.NormalHR;
import com.assignment.entity.employee.staff.Staff;

import java.util.List;


public class EmployeeDAOProxy implements IEmployeeDAO {
    public static final String SERVICE_NAME = "EmployeeDAOProxy";
    EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    @Override
    public Doctor findDoctorById(int id) {
        return employeeDAO.findDoctorById(id);
    }

    @Override
    public Nurse findNurseById(int nurseId) {
        return employeeDAO.findNurseById(nurseId);
    }

    @Override
    public Staff findStaffById(int staffId) {
        return employeeDAO.findStaffById(staffId);
    }

    @Override
    public List<NormalHR> findAllNormalHR() {
        return employeeDAO.findAllNormalHR();
    }

    @Override
    public ServiceChief findChiefById(int id) {
        return employeeDAO.findChiefById(id);
    }

    @Override
    public Employee findHealthcareEmployeeById(int id) {
        return employeeDAO.findHealthcareEmployeeById(id);
    }

    @Override
    public void removeEmployee(Employee toBeDismissed) {
        employeeDAO.removeEmployee(toBeDismissed);
    }

    @Override
    public void recruitEmployee(Employee toBeRecruit) {
        employeeDAO.recruitEmployee(toBeRecruit);
    }
}
