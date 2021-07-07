package com.assignment.factory;

import com.assignment.service.*;
import com.assignment.service.dao.*;

public class ServicesFactory {

    public static <T extends Object> T getService(String serviceName) {
        switch (serviceName) {

            case EmployeeDAO.SERVICE_NAME:
                return (T) new EmployeeDAO();
            case EmployeeDAOProxy.SERVICE_NAME:
                return (T) new EmployeeDAOProxy();
            case DoctorAssignment.SERVICE_NAME:
                return (T) new DoctorAssignment();
            case NurseAssignment.SERVICE_NAME:
                return (T) new NurseAssignment();
            case StaffAssignment.SERVICE_NAME:
                return (T) new StaffAssignment();
            case EquipmentDAOProxy.SERVICE_NAME:
                return (T) new EquipmentDAOProxy();
            case ActivityDAOProxy.SERVICE_NAME:
                return (T) new ActivityDAOProxy();
            case PatientDAO.SERVICE_NAME:
                return (T) new PatientDAO();
            case HumanResourcesService.SERVICE_NAME:
                return (T) new HumanResourcesService();
            case RestockEquipmentsService.SERVICE_NAME:
                return (T) new RestockEquipmentsService();
            case PatientDAOProxy.SERVICE_NAME:
                return (T) new PatientDAOProxy();
            case EquipmentDAO.SERVICE_NAME:
                return (T) new EquipmentDAO();
            case ActivityDAO.SERVICE_NAME:
                return (T) new ActivityDAO();
            default:
                return null;
        }
    }

}
