package com.assignment.service.dao;

import com.assignment.entity.employee.Employee;
import com.assignment.entity.employee.healthcare.Doctor;
import com.assignment.entity.employee.healthcare.HealthcareEmployee;
import com.assignment.entity.employee.healthcare.Nurse;
import com.assignment.entity.employee.healthcare.ServiceChief;
import com.assignment.entity.employee.humanresource.NormalHR;
import com.assignment.entity.employee.staff.Staff;
import com.assignment.stubdata.EmployeeStubData;

import java.util.Iterator;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {

    public static final String SERVICE_NAME = "EmployeeDAO";

    public void addEmployee(Employee employee) {
        int employeeId = 1;

        if (employee instanceof Doctor) {
            if (!EmployeeStubData.doctorListDraft.isEmpty()) {
                employeeId = EmployeeStubData.doctorListDraft.get(EmployeeStubData.doctorListDraft.size() - 1).getId() + 1;
            }
            employee.setId(employeeId);
            EmployeeStubData.doctorListDraft.add((Doctor) employee);
        } else if (employee instanceof Nurse) {
            if (!EmployeeStubData.nurseListDraft.isEmpty()) {
                employeeId = EmployeeStubData.nurseListDraft.get(EmployeeStubData.nurseListDraft.size() - 1).getId() + 1;
            }
            employee.setId(employeeId);
            EmployeeStubData.nurseListDraft.add((Nurse) employee);
        } else if (employee instanceof Staff) {
            if (!EmployeeStubData.staffListDraft.isEmpty()) {
                employeeId = EmployeeStubData.staffListDraft.get(EmployeeStubData.serviceChiefList.size() - 1).getId() + 1;
            }
            employee.setId(employeeId);
            EmployeeStubData.staffListDraft.add((Staff) employee);
        }
    }

    public Doctor findDoctorById(int id) {
        for (Doctor doctor : EmployeeStubData.doctorList) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    public Nurse findNurseById(int nurseId) {
        for (Nurse nurse : EmployeeStubData.nurseList) {
            if (nurse.getId() == nurseId) {
                return nurse;
            }
        }
        return null;
    }

    public Staff findStaffById(int staffId) {
        for (Staff staff : EmployeeStubData.staffList) {
            if (staff.getId() == staffId) {
                return staff;
            }
        }
        return null;
    }

    public List<NormalHR> findAllNormalHR() {
        return EmployeeStubData.normalHRList;
    }

    public ServiceChief findChiefById(int id) {
        for (ServiceChief serviceChief : EmployeeStubData.serviceChiefList) {
            if (serviceChief.getId() == id) {
                return serviceChief;
            }
        }
        return null;
    }

    //TODO: should be better if-else
    public Employee findHealthcareEmployeeById(int id) {
        Employee healthcareEmployee = findDoctorById(id);
        System.out.println("Searching in the doctors list...");
        if (healthcareEmployee != null) {
            System.out.println("Found a doctor: " + healthcareEmployee);
            return healthcareEmployee;
        } else {
            System.out.println("Not found! Continue searching in the nurses list...");
            healthcareEmployee = findNurseById(id);
            if (healthcareEmployee != null) {
                System.out.println("Found a nurse: " + healthcareEmployee);
                return healthcareEmployee;
            } else {

                System.out.println("Not found! Continue searching in the service chiefs list...");
                healthcareEmployee = findChiefById(id);
                if (healthcareEmployee != null) {
                    System.out.println("Found a chief: " + healthcareEmployee);
                    return healthcareEmployee;
                }
            }
        }
        System.out.println("Not found any employee with ID: " + id);
        return null;
    }


    public void removeEmployee(Employee toBeDismissed) {
        if (toBeDismissed instanceof Doctor) {
            Iterator<Doctor> doctorIterator = EmployeeStubData.doctorList.iterator();
            while (doctorIterator.hasNext()) {
                HealthcareEmployee found = doctorIterator.next();
                if (found.getId() == toBeDismissed.getId()) {
                    doctorIterator.remove();
                    return;
                }
            }
        } else if (toBeDismissed instanceof Nurse) {
            Iterator<Nurse> doctorIterator = EmployeeStubData.nurseList.iterator();
            while (doctorIterator.hasNext()) {
                HealthcareEmployee found = doctorIterator.next();
                if (found.getId() == toBeDismissed.getId()) {
                    doctorIterator.remove();
                    return;
                }
            }
        } else if (toBeDismissed instanceof ServiceChief) {
            Iterator<ServiceChief> doctorIterator = EmployeeStubData.serviceChiefList.iterator();
            while (doctorIterator.hasNext()) {
                HealthcareEmployee found = doctorIterator.next();
                if (found.getId() == toBeDismissed.getId()) {
                    doctorIterator.remove();
                    return;
                }
            }
        }
        System.out.println("Removed : " + toBeDismissed);
    }

    @Override
    public void recruitEmployee(Employee toBeRecruit) {
        EmployeeStubData.recruitEmployeeList.add(toBeRecruit);
        if (toBeRecruit instanceof Doctor) {
            System.out.println("Recruit Doctor");
        }
        if (toBeRecruit instanceof Nurse) {
            System.out.println("Recruit Nurse");
        }
        if (toBeRecruit instanceof Staff) {
            System.out.println("Recruit Staff");
        }
    }
}
