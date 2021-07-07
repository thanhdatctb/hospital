package com.assignment.service.dao;

import com.assignment.entity.employee.Employee;
import com.assignment.entity.employee.healthcare.Doctor;
import com.assignment.entity.employee.healthcare.Nurse;
import com.assignment.entity.employee.healthcare.ServiceChief;
import com.assignment.entity.employee.humanresource.NormalHR;
import com.assignment.entity.employee.staff.Staff;

import java.util.List;

public interface IEmployeeDAO {
    public void addEmployee(Employee employee);

    public Doctor findDoctorById(int id);

    public Nurse findNurseById(int nurseId);

    public Staff findStaffById(int staffId);

    public List<NormalHR> findAllNormalHR();

    public ServiceChief findChiefById(int id);

    public Employee findHealthcareEmployeeById(int id);

    public void removeEmployee(Employee toBeDismissed);

    public void recruitEmployee(Employee toBeRecruit);
}
