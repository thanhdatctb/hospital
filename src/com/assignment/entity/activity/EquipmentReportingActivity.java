package com.assignment.entity.activity;

public class EquipmentReportingActivity extends Activity{

    public static final String REPORT = "EquipmentReportingActivity";
    String reportingInformation;

    public EquipmentReportingActivity(String name, String reportingInformation) {
        super(name);
        this.reportingInformation = reportingInformation;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEquipment Reports: \n{\n"
                + reportingInformation  +
                "\n}";
    }
}
