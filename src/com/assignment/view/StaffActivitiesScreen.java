package com.assignment.view;

import com.assignment.Main;
import com.assignment.entity.activity.Activity;
import com.assignment.entity.activity.EquipmentReportingActivity;
import com.assignment.entity.employee.staff.CleaningStaff;
import com.assignment.entity.employee.staff.InventoryStaff;
import com.assignment.entity.employee.staff.LaundryStaff;
import com.assignment.entity.equipment.EquipmentType;
import com.assignment.stubdata.EmployeeStubData;

import java.util.Scanner;

public class StaffActivitiesScreen extends Main implements IFacadeScreen {

    public void printStaffActivities(){
        boolean loop = true;
        while (loop){
            System.out.println("\n--- Staff Activities ---");
            System.out.println("1. Perform cleaning");
            System.out.println("2. Perform laundry");
            System.out.println("3. Inventory check and report");
            System.out.println("0. Back to main menu");
            System.out.println("-------------------------");

            Scanner input = new Scanner(System.in);

            int item = input.nextInt();

            input.nextLine();

            switch(item){
                case 1:
                    System.out.println("List of cleaning staff: ");
                    for (CleaningStaff cleaningStaff : EmployeeStubData.cleaningStaffList){
                        System.out.println(cleaningStaff);
                    }
                    System.out.println("------------End Of the cleaning staff list-----------------");
                    System.out.println("\n");

                    Activity cleaningActivity = new Activity(Activity.CLEANING);
                    staffAssignment.assignActivity(cleaningActivity);
                    break;

                case 2:
                    System.out.println("List of laundry staff: ");
                    for (LaundryStaff laundryStaff : EmployeeStubData.laundryStaffList){
                        System.out.println(laundryStaff);
                    }
                    System.out.println("------------End Of the laundry staff list-----------------");
                    System.out.println("\n");

                    Activity landryActivity = new Activity(Activity.LAUNDRY);
                    staffAssignment.assignActivity(landryActivity);

                    break;

                case 3:
                    System.out.println("List of inventory staff: ");
                    for (InventoryStaff inventoryStaff : EmployeeStubData.inventoryStaffList){
                        System.out.println(inventoryStaff);
                    }
                    System.out.println("------------End Of the inventory staff list-----------------");
                    System.out.println("\n");

                    int consumedHealthCareEqCount = equipmentDAO.numberOfConsumedEquipments(EquipmentType.HEALTHCARE);
                    int consumedStaffEqCount = equipmentDAO.numberOfConsumedEquipments(EquipmentType.STAFF);
                    String consumedHealthCareEqCountStr = "Number of consumed health care equipments: " + consumedHealthCareEqCount;
                    String consumedStaffEqCountStr = "Number of consumed staff equipments: " + consumedStaffEqCount;

                    String missingEquipmentInfo = consumedHealthCareEqCountStr + "\n" + consumedStaffEqCountStr;
                    EquipmentReportingActivity equipmentReportingActivity = new EquipmentReportingActivity(EquipmentReportingActivity.REPORT, missingEquipmentInfo);
                    staffAssignment.assignActivity(equipmentReportingActivity);

                    break;

                case 0:
                    loop=false;
                    System.out.println("Exiting Staff Activities... ");
                    break;
            }

        }
    }

    @Override
    public void show() {
        printStaffActivities();
    }
}
