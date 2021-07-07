package com.assignment.service.dao;

import com.assignment.entity.activity.Activity;
import com.assignment.entity.activity.EquipmentReportingActivity;

import java.util.List;

public interface IActivityDAO {
    public void addActivity(Activity activity);
    public int activityCountByEmployeeId(int employeeId);
    public List<EquipmentReportingActivity> findAllReports();
}
