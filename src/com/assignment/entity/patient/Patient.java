package com.assignment.entity.patient;

import com.assignment.entity.employee.healthcare.Doctor;
import com.assignment.entity.employee.healthcare.Nurse;

public class Patient {
    int id;
    String name;
    int age;
    DiseaseType diseaseType;
    boolean isHealed;
    Doctor doctor;
    Nurse nurse;

    public Patient(int id, String name, int age, DiseaseType diseaseType, boolean isHealed) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.diseaseType = diseaseType;
        this.isHealed = isHealed;
    }

    public Patient(String name, int age, DiseaseType diseaseType, boolean isHealed) {
        this.name = name;
        this.age = age;
        this.diseaseType = diseaseType;
        this.isHealed = isHealed;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public void isHealed(boolean healed) {
        isHealed = healed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public DiseaseType getDiseaseType() {
        return diseaseType;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Nurse getNurse() {
        return nurse;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", diseaseType=" + diseaseType +
                ", isHealed=" + isHealed + "}" +
                "\nThe assigned Doctor: " + doctor +
                "\nThe assigned Nurse: " + nurse + "\n------End of Patient Info------\n";
    }
}
