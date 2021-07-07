package com.assignment.view;

import com.assignment.Main;
import com.assignment.entity.employee.Employee;
import com.assignment.entity.employee.healthcare.Doctor;
import com.assignment.entity.employee.healthcare.Nurse;
import com.assignment.entity.employee.healthcare.Staff;
import com.assignment.entity.floor.Floor;
import com.assignment.entity.patient.DiseaseType;
import com.assignment.entity.patient.Patient;
import com.assignment.entity.room.OperationRoom;
import com.assignment.entity.room.patient.SinglePatientRoom;
import com.assignment.entity.service.Service;
import com.assignment.factory.EmployeeFactory;
import com.assignment.stubdata.EmployeeStubData;

import java.util.Scanner;

public class HRActivitiesScreen extends Main implements IFacadeScreen {
    public void printHRActivities() {
        boolean loop = true;
        while (loop) {
            System.out.println("--- Human Resource ---");
            System.out.println("1. Recruit new employee");
            System.out.println("2. Search and Dismiss employee");
            System.out.println("3. Exit patient and create invoice");
            System.out.println("4. Check list request recruit");
            System.out.println("5. Move patient to room");
            System.out.println("6. Create Bill");
            System.out.println("0. Back to main menu");
            System.out.println("--------------------------------\n");

            Scanner input = new Scanner(System.in);
            int item = input.nextInt();
            input.nextLine();

            switch (item) {
                case 1:
                    System.out.println("Adding a new employee");
                    System.out.println("Position: (D - doctor | N - Nurse | S - Staff");
                    String position = input.nextLine();
                    System.out.println("Input name: ");
                    String name = input.nextLine();
                    Employee newEmployee = EmployeeFactory.createEmployee(position, name);
                    employeeDAO.addEmployee(newEmployee);
                    break;
                case 2:
                    System.out.println("Dismissing an employee");
                    System.out.println("Input employee id: ");
                    int id = input.nextInt();
                    input.nextLine();
                    Employee toBeDismissed = employeeDAO.findHealthcareEmployeeById(id);
                    if (toBeDismissed != null) {
                        employeeDAO.removeEmployee(toBeDismissed);
                    }
                    break;
                case 3:
                    System.out.println("Exiting a patient");
                    System.out.println("Input patient id: ");
                    int patientId = input.nextInt();
                    input.nextLine();
                    Patient toBeRemoved = patientDAO.findPatientById(patientId);
                    if (toBeRemoved != null) {
                        patientDAO.removePatient(toBeRemoved);
                    }
                    break;
                case 4:
                    int size = EmployeeStubData.recruitEmployeeList.size();
                    System.out.println("You have " + size + " request recruit");
                    for (Employee employee : EmployeeStubData.recruitEmployeeList) {
                        if (employee instanceof Doctor) {
                            System.out.println("Recruit Doctor");
                        }
                        if (employee instanceof Nurse) {
                            System.out.println("Recruit Nurse");
                        }
                        if (employee instanceof Staff) {
                            System.out.println("Recruit Staff");
                        }
                    }

                case 5:
                    System.out.println("Input patient id: ");
                    patientId = input.nextInt();
                    input.nextLine();
                    Patient patient = patientDAO.findPatientById(patientId);
                    while (patient == null) {
                        System.out.println("Cannot find any Patient with id " + patientId + " .Please re-input or -1 to exit");
                        id = input.nextInt();
                        if (id == -1) {
                            break;
                        } else {
                            patient = patientDAO.findPatientById(id);
                            input.nextLine();
                        }
                    }
                    if (patient != null) {
                        System.out.println(" Found patient:  " + patient);
                        System.out.println("Do you to assign doctor/nurse for this patient? (Y/N)");
                        String answer = input.nextLine();
                        if (answer.trim().equals("Y")) {
                            doctorAssignment.assignPatient(patient);
                            nurseAssignment.assignPatient(patient);
                            Floor floor = new Floor(1, "test") {
                                @Override
                                public void setService(Service service) {
                                    super.setService(service);
                                }
                            };
                            if (patient.getDiseaseType() == DiseaseType.MEDICAL) {
                                patient.setRoom(new SinglePatientRoom(floor, 1, patient.getName()));
                            } else if (patient.getDiseaseType() == DiseaseType.OPERATION) {
                                patient.setRoom(new OperationRoom(floor, 1, patient.getName()));
                            }
                            System.out.println(patient);
                        } else if (answer.trim().equals("N")) {
                            break;
                        }
                    }
                    break;

                case 6:
                    System.out.println("Input patient id: ");
                    patientId = input.nextInt();
                    input.nextLine();
                    patient = patientDAO.findPatientById(patientId);
                    while (patient == null) {
                        System.out.println("Cannot find any Patient with id " + patientId + " .Please re-input or -1 to exit");
                        id = input.nextInt();
                        if (id == -1) {
                            break;
                        } else {
                            patient = patientDAO.findPatientById(id);
                            input.nextLine();
                        }
                    }

                    if (patient != null) {
                        int bill = 50;
                        if (patient.getDiseaseType() == DiseaseType.MEDICAL) {
                            bill += 80;
                        } else if (patient.getDiseaseType() == DiseaseType.OPERATION) {
                            bill += 100;
                        }
                        System.out.println(patient);
                        System.out.println("Your bill :" + bill);
                        patientDAO.removePatient(patient);
                    }

                    break;
                case 0:
                    loop = false;
                    System.out.println("Exiting Human Resource....");
                    break;
                default:
                    System.out.println("The input '" + item + "' is invalid! Please choose again the menu number!");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    break;
            }
        }
    }

    @Override
    public void show() {
        printHRActivities();
    }
}//aaa