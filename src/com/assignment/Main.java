package com.assignment;

import com.assignment.factory.ServicesFactory;
import com.assignment.observer.IHumanResourcesObserver;
import com.assignment.service.DoctorAssignment;
import com.assignment.service.NurseAssignment;
import com.assignment.service.RestockEquipmentsService;
import com.assignment.service.StaffAssignment;
import com.assignment.service.dao.ActivityDAOProxy;
import com.assignment.service.dao.EmployeeDAOProxy;
import com.assignment.service.dao.EquipmentDAOProxy;
import com.assignment.service.dao.PatientDAOProxy;
import com.assignment.view.ScreenMaker;

import java.util.Scanner;

public class Main {
    protected IHumanResourcesObserver humanResourcesObserver;
    protected EmployeeDAOProxy employeeDAO;
    protected DoctorAssignment doctorAssignment;
    protected NurseAssignment nurseAssignment;
    protected PatientDAOProxy patientDAO;
    protected ActivityDAOProxy activityDAO;
    protected StaffAssignment staffAssignment;
    protected EquipmentDAOProxy equipmentDAO;
    protected RestockEquipmentsService restockEquipmentsService;

    public Main() {
        this.employeeDAO = ServicesFactory.getService(EmployeeDAOProxy.SERVICE_NAME);
        this.doctorAssignment = ServicesFactory.getService(DoctorAssignment.SERVICE_NAME);
        this.nurseAssignment = ServicesFactory.getService(NurseAssignment.SERVICE_NAME);
        this.patientDAO = ServicesFactory.getService(PatientDAOProxy.SERVICE_NAME);
        this.activityDAO = ServicesFactory.getService(ActivityDAOProxy.SERVICE_NAME);
        this.staffAssignment = ServicesFactory.getService(StaffAssignment.SERVICE_NAME);
        this.equipmentDAO = ServicesFactory.getService(EquipmentDAOProxy.SERVICE_NAME);
        this.restockEquipmentsService = ServicesFactory.getService(RestockEquipmentsService.SERVICE_NAME);

    }

    public static void main(String[] args) {
        boolean loop = true;
        while (loop) {
            System.out.println("--- Hospital Management System ---");
            System.out.println("1. Chief Service activities");
            System.out.println("2. Flow demo");

            Scanner input = new Scanner(System.in);
            int item = input.nextInt();
            input.nextLine();

            switch (item) {
                case 1:
                    action();
                    break;
                case 2:
                    action();
                    break;
                default:
                    System.out.println("The input '" + item + "' is invalid! Please choose again the menu number!");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    break;
            }
        }
    }
    public static void action(){
        ScreenMaker screenMaker = new ScreenMaker();
        boolean loop = true;
        while (loop) {
            System.out.println("--- Hospital Management System ---");
            System.out.println("1. Chief Service activities");
            System.out.println("2. Staff activities");
            System.out.println("3. Doctor - Treatment");
            System.out.println("4. Human resource");
            System.out.println("5. Director Activities");
            System.out.println("0. Exit");
            System.out.println("--------------------------------\n");

            Scanner input = new Scanner(System.in);
            int item = input.nextInt();
            input.nextLine();

            switch (item) {
                case 1:
                    screenMaker.showChiefActivitiesScreen();
                    break;
                case 2:
                    screenMaker.showStaffActivitiesScreen();
                    break;
                case 3:
                    screenMaker.showDoctorActivitiesScreen();
                    break;
                case 4:
                    screenMaker.showHRActivitiesScreen();
                    break;
                case 5:
                    screenMaker.showDirectortivitiesScreen();
                    break;
                case 0:
                    loop = false;
                    System.out.println("Thanks for using the Hospital Management System, see you next time.");
                    break;
                default:
                    System.out.println("The input '" + item + "' is invalid! Please choose again the menu number!");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    break;
            }
        }
    }
}
