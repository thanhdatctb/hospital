package com.assignment.view;

import com.assignment.Main;
import com.assignment.entity.activity.EquipmentReportingActivity;
import com.assignment.entity.employee.Employee;
import com.assignment.entity.employee.healthcare.ServiceChief;
import com.assignment.entity.equipment.EquipmentType;
import com.assignment.entity.patient.DiseaseType;
import com.assignment.entity.patient.Patient;
import com.assignment.factory.EmployeeFactory;
import com.assignment.factory.ServicesFactory;
import com.assignment.observer.IHumanResourcesObservable;
import com.assignment.observer.IHumanResourcesObserver;
import com.assignment.service.EquipmentStatusService;
import com.assignment.service.HumanResourcesService;
import com.assignment.stubdata.EmployeeStubData;

import java.util.List;
import java.util.Scanner;

public class ChiefActivitiesScreen extends Main implements IHumanResourcesObservable, IFacadeScreen {

    public ChiefActivitiesScreen() {
        attach(ServicesFactory.getService(HumanResourcesService.SERVICE_NAME));
    }

    public void printChiefActivities() {
        boolean loop = true;
        while (loop) {
            System.out.println("\n--- Chief Activities ---");
            System.out.println("1. Accept a new patient & Notify HR");
            System.out.println("2. Search a patient - Assign doctor/nurse");
            System.out.println("3. Check the equipment reports - Command new equipments");
            System.out.println("0. Back to main menu");
            System.out.println("-------------------------");

            Scanner input = new Scanner(System.in);
            int item = input.nextInt();
            input.nextLine();

            switch (item) {
                case 1:
                    ServiceChief chief = getServiceChief();
                    if (chief == null) {
                        break;
                    }
                    System.out.println("Input the patient name: ");
                    String patientName = input.nextLine();

                    System.out.println("Input the patient age: ");
                    int patientAge = input.nextInt();
                    input.nextLine();

                    System.out.println("Disease Type: ('M' for Medical | 'O' for Operation");
                    String diseaseType = input.nextLine();
                    DiseaseType enumDiseaseType = null;
                    if ("M".equals(diseaseType)) {
                        enumDiseaseType = DiseaseType.MEDICAL;
                    } else if ("O".equals(diseaseType)) {
                        enumDiseaseType = DiseaseType.OPERATION;
                    }

                    //initialize patient
                    Patient patient = new Patient(patientName, patientAge, enumDiseaseType, false);
                    //find and assign doctor
                    doctorAssignment.assignPatient(patient);
                    //engage the nurse assignment activity with the EquipmentObserver
                    nurseAssignment.attach(new EquipmentStatusService());
                    //find and assign the nurse
                    nurseAssignment.assignPatient(patient);
                    //notify HR
                    notifyObserver(patient);

                    break;
                case 2:
                    chief = getServiceChief();
                    if (chief == null) {
                        break;
                    }
                    Patient foundPatient = searchPatient();
                    if (foundPatient != null) {
                        System.out.println("Do you to assign doctor/nurse for this patient? (Y/N)");
                        String answer = input.nextLine();
                        if (answer.trim().equals("Y")) {
                            //find and assign doctor
                            doctorAssignment.assignPatient(foundPatient);
                            //engage the nurse assignment activity with the EquipmentObserver
//                            nurseAssignment.attach(new EquipmentStatusService());
                            //find and assign the nurse
                            nurseAssignment.assignPatient(foundPatient);
                            //notify HR
                            notifyObserver(foundPatient);
                        } else if (answer.trim().equals("N")) {
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("---- The equipments reports -----");
                    List<EquipmentReportingActivity> allReports = activityDAO.findAllReports();
                    for (EquipmentReportingActivity rp : allReports) {
                        System.out.println(rp);
                        System.out.println("-----------------------------\n");
                    }
                    if (allReports.isEmpty()) {
                        System.out.println("There is no reports currently!");
                    }
                    System.out.println("--------------------------------");
                    System.out.println("Command to restock the equipments");
                    System.out.println("Type of Equipment? ( H - Healthcare | S - Staff | any other letter to exit)");
                    String type = input.nextLine();
                    System.out.println("Quantity of Equipments?");
                    int quantity = input.nextInt();
                    if (type.equals("H")) {
                        restockEquipmentsService.takeRestockInfo(quantity, EquipmentType.HEALTHCARE);
                    } else if (type.equals("S")) {
                        restockEquipmentsService.takeRestockInfo(quantity, EquipmentType.STAFF);
                    } else {
                        break;
                    }
                    //command to restock
                    restockEquipmentsService.doRestock();
                    break;

                case 4:
                    System.out.println("Request a new employee");
                    System.out.println("Position: (D - doctor | N - Nurse | S - Staff");
                    String position = input.nextLine();
                    Employee newEmployee = EmployeeFactory.recruitEmployee(position);
                    employeeDAO.recruitEmployee(newEmployee);
                    break;

                case 5:
                    if (EmployeeStubData.nurseListDraft.isEmpty() && EmployeeStubData.doctorListDraft.isEmpty() && EmployeeStubData.staffListDraft.isEmpty()) {
                        System.out.println("You dont have any request:");
                    } else {
                        if (!EmployeeStubData.nurseListDraft.isEmpty()) {
                            System.out.println("You have " + EmployeeStubData.nurseListDraft.size() + " request nurse");
                        }
                        if (!EmployeeStubData.doctorListDraft.isEmpty()) {
                            System.out.println("You have " + EmployeeStubData.doctorListDraft.size() + " request doctor");
                        }
                        if (!EmployeeStubData.staffListDraft.isEmpty()) {
                            System.out.println("You have " + EmployeeStubData.staffListDraft.size() + " staff nurse");
                        }
                        System.out.println("you wanto approval");
                    }

                    break;
                case 0:
                    loop = false;
                    System.out.println("Exiting Chief Activities... ");
                    break;
            }
        }
    }

    @Override
    public void attach(IHumanResourcesObserver observer) {
        this.humanResourcesObserver = observer;
    }

    @Override
    public void notifyObserver(Patient patient) {
        humanResourcesObserver.acknowledgeNewPatient(patient);
    }

    private ServiceChief getServiceChief() {
        //find chief
        System.out.println("Hello Chief! Please input your id: ");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        input.nextLine();
        ServiceChief chief = employeeDAO.findChiefById(id);
        while (chief == null) {
            System.out.println("Cannot find any Chief with id " + id + " .Please re-input or -1 to exit");
            id = input.nextInt();
            if (id == -1) {
                break;
            } else {
                chief = employeeDAO.findChiefById(id);
                input.nextLine();
            }
        }
        if (chief != null) {
            System.out.println(" Welcome chief:  " + chief);
        }
        return chief;
    }

    public Patient searchPatient() {
        System.out.println("Please input patient id: ");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        input.nextLine();
        Patient patient = patientDAO.findPatientById(id);
        while (patient == null) {
            System.out.println("Cannot find any Patient with id " + id + " .Please re-input or -1 to exit");
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
        }
        return patient;
    }

    @Override
    public void show() {
        printChiefActivities();
    }
}
