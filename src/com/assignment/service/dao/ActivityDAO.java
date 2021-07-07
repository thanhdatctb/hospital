package com.assignment.service.dao;

import com.assignment.entity.activity.Activity;
import com.assignment.entity.activity.EquipmentReportingActivity;
import com.assignment.stubdata.ActivityStubData;

import java.util.List;

public class ActivityDAO implements IActivityDAO{
    public static final String SERVICE_NAME = "ActivityDAO";

    public void addActivity(Activity activity){
        int activityId = 1;
        if (activity instanceof EquipmentReportingActivity ){
            if(!ActivityStubData.reportsList.isEmpty()){
                activityId = ActivityStubData.reportsList.get(ActivityStubData.reportsList.size()-1).getId() + 1;
                ActivityStubData.reportsList.add((EquipmentReportingActivity)activity);
            }
        } else {
            if(!ActivityStubData.activityList.isEmpty()){
                activityId = ActivityStubData.activityList.get(ActivityStubData.activityList.size()-1).getId() + 1;
                ActivityStubData.activityList.add(activity);
            }
        }
        activity.setId(activityId);
    }

    public int activityCountByEmployeeId(int employeeId){
        int i = 0;
        for (Activity activity : ActivityStubData.activityList) {
            if (activity.getEmployee() != null && activity.getEmployee().getId() == employeeId){
                i++;
            }
        }
        return i;
    }

    public List<EquipmentReportingActivity> findAllReports(){
        return ActivityStubData.reportsList;
    }
}
