package com.assignment.view;

import com.assignment.Main;
import com.assignment.entity.employee.Employee;
import com.assignment.factory.EmployeeFactory;
import com.assignment.stubdata.EmployeeStubData;

import java.util.Scanner;

public class DirectorActivitiesScreen extends Main implements IFacadeScreen {

    public void printStaffActivities() {
        boolean loop = true;
        while (loop) {
            System.out.println("\n--- Director Activities ---");
            System.out.println("1. Request HR recruit");
            System.out.println("2. Approval request HR recruit");
            System.out.println("0. Back to main menu");
            System.out.println("-------------------------");

            Scanner input = new Scanner(System.in);

            int item = input.nextInt();

            input.nextLine();

            switch (item) {
                case 1:
                    System.out.println("Request a new employee");
                    System.out.println("Position: (D - doctor | N - Nurse | S - Staff");
                    String position = input.nextLine();
                    Employee newEmployee = EmployeeFactory.recruitEmployee(position);
                    employeeDAO.recruitEmployee(newEmployee);
                    break;

                case 2:
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
                        System.out.println("you want to approval all request");
                        System.out.println("Do you to assign doctor/nurse for this patient? (Y/N)");
                        String answer = input.nextLine();
                        if (answer.trim().equals("Y")) {
                            EmployeeStubData.nurseList.addAll(EmployeeStubData.nurseListDraft);
                            EmployeeStubData.doctorList.addAll(EmployeeStubData.doctorListDraft);
                            EmployeeStubData.staffList.addAll(EmployeeStubData.staffListDraft);
                        } else if (answer.trim().equals("N")) {
                            break;
                        }
                    }
                    break;
                case 0:
                    loop = false;
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
