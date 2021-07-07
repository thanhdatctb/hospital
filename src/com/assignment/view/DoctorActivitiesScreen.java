package com.assignment.view;

import com.assignment.Main;
import com.assignment.entity.employee.healthcare.Doctor;
import com.assignment.entity.equipment.EquipmentType;
import com.assignment.entity.patient.DiseaseType;
import com.assignment.entity.patient.Patient;
import com.assignment.observer.IEquipmentObservable;
import com.assignment.observer.IEquipmentObserver;
import com.assignment.service.EquipmentStatusService;

import java.util.List;
import java.util.Scanner;

public class DoctorActivitiesScreen extends Main implements IEquipmentObservable, IFacadeScreen {

    private IEquipmentObserver equipmentObserver;
    private int numberOfConsumedEquipment;
    private boolean isComsumingEquipments = true;

    public DoctorActivitiesScreen() {
        super();
        attach(new EquipmentStatusService());
    }

    public void printDoctorActivities() {

        boolean loop = true;
        while (loop) {
            System.out.println("\n--- Doctor - Treatment ---");
            System.out.println("1. Medical treatment");
            System.out.println("2. Operation treatment");
            System.out.println("3. Follow up (1 day)");
            System.out.println("4. Finish treating");
            System.out.println("0. Back to main menu");
            System.out.println("-------------------------");

            Scanner input = new Scanner(System.in);

            int item = input.nextInt();

            input.nextLine();
            Doctor doctor;
            switch (item) {
                case 1:
                    System.out.println("Welcome to Medical Treatment area");
                    doctor = getDoctor();
                    if (doctor != null) {
                        System.out.println("--------------------------------");
                        System.out.println("Below is your medical patient list");
                        List<Patient> patientList = doctor.getPatientList();
                        for (Patient patient : patientList) {
                            if (patient.getDiseaseType().equals(DiseaseType.MEDICAL)) {
                                System.out.println(patient);
                            }
                        }
                        if (patientList.isEmpty()) {
                            System.out.println("Sorry ! you don't have any medical patient ");
                        } else {
                            //select patient to treat
                            System.out.println("Select your patient id: ");
                            int patientId = input.nextInt();
                            input.nextLine();
                            //notify to update the equipments status
                            for (Patient patient : patientList) {
                                if (patient.getId() == patientId) {
                                    System.out.println("Your medical patient info:  ");
                                    patient.toString();
                                    break;
                                }
                            }
                            numberOfConsumedEquipment = 2;
                            notifyObservers();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Welcome to Operation Treatment area");
                    doctor = getDoctor();
                    if (doctor != null) {
                        System.out.println("--------------------------------");
                        System.out.println("Below is your operation patient list");
                        for (Patient patient : doctor.getPatientList()) {
                            if (patient.getDiseaseType().equals(DiseaseType.OPERATION)) {
                                System.out.println(patient);
                            }
                        }
                        //select patient to treat
                        System.out.println("Select your patient id: ");
                        int patientId = input.nextInt();
                        input.nextLine();
                        //notify to update the equipments status
                        List<Patient> patientList = doctor.getPatientList();
                        for (Patient patient : patientList) {
                            if (patient.getId() == patientId) {
                                nurseAssignment.assignPatient(patient);
                                break;
                            }
                        }
                        numberOfConsumedEquipment = 2;
                        notifyObservers();
                        break;
                    }

                case 3:
                    System.out.println("Follow up patient(s)");
                    doctor = getDoctor();
                    if (doctor != null) {
                        System.out.println("--------------------------------");
                        System.out.println("Below is your operation patient list");
                        for (Patient patient : doctor.getPatientList()) {
                            if (patient.getDiseaseType().equals(DiseaseType.OPERATION)) {
                                System.out.println(patient);
                            }
                        }
                        //select patient to treat
                        System.out.println("Select your patient id: ");
                        int patientId = input.nextInt();
                        input.nextLine();
                        //notify to update the equipments status
                        numberOfConsumedEquipment = 2;
                        notifyObservers();
                        break;
                    }
                    break;
                case 4:
                    System.out.println("Finishing treating. The equipments will be released....");
                    System.out.println("Select your treating type: (M - Medical | O - Operation | F - Follow up)");
                    String type = input.nextLine();
                    if (type.equals("M") || type.equals("F")) {
                        numberOfConsumedEquipment = 2;
                    } else if (type.equals("O")) {
                        numberOfConsumedEquipment = 5;
                    }
                    isComsumingEquipments = false;
                    //release the equipments
                    notifyObservers();
                    break;
                case 0:
                    loop = false;
                    System.out.println("Exiting Doctor - Treatment...");
                    break;
                default:
                    System.out.println("The input '" + item + "' is invalid! Please choose again the menu number!");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    break;
            }
        }
    }


    private Doctor getDoctor() {
        //find doctor
        System.out.println("Doctor, please input your id: ");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        input.nextLine();
        Doctor doctor = employeeDAO.findDoctorById(id);
        while (doctor == null) {
            System.out.println("Cannot find any doctor with id " + id + " .Please re-input or -1 to exit");
            id = input.nextInt();
            if (id == -1) {
                break;
            } else {
                doctor = employeeDAO.findDoctorById(id);
                input.nextLine();
            }
        }
        if (doctor != null) {
            System.out.println(" Welcome doctor:  " + doctor);
        }
        return doctor;
    }


    @Override
    public void attach(IEquipmentObserver observer) {
        this.equipmentObserver = observer;
    }

    @Override
    public void detach(IEquipmentObserver observer) {

    }

    @Override
    public void notifyObservers() {
        if (equipmentObserver != null) {
            equipmentObserver.updateEquipmentsStatus(numberOfConsumedEquipment, EquipmentType.HEALTHCARE, isComsumingEquipments);
        }
    }

    @Override
    public void show() {
        printDoctorActivities();
    }
}
