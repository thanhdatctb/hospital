package com.assignment.service.dao;

import com.assignment.entity.activity.Activity;
import com.assignment.entity.activity.EquipmentReportingActivity;

import java.util.List;

public class ActivityDAOProxy implements IActivityDAO{
    public static final String SERVICE_NAME = "ActivityDAOProxy";
    ActivityDAO activityDAO = new ActivityDAO();

    @Override
    public void addActivity(Activity activity) {
        activityDAO.addActivity(activity);
    }

    @Override
    public int activityCountByEmployeeId(int employeeId) {
        return activityDAO.activityCountByEmployeeId(employeeId);
    }

    @Override
    public List<EquipmentReportingActivity> findAllReports() {
        return activityDAO.findAllReports();
    }
}
