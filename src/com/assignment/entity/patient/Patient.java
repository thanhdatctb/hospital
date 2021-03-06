package com.assignment.entity.patient;

import com.assignment.entity.employee.healthcare.Doctor;
import com.assignment.entity.employee.healthcare.Nurse;
import com.assignment.entity.room.Room;

public class Patient {
    int id;
    String name;
    int age;
    DiseaseType diseaseType;
    boolean isHealed;
    Doctor doctor;
    Nurse nurse;
    Room room;


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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", diseaseType=" + diseaseType +
                ", room=" + room +
                ", isHealed=" + isHealed + "}" +
                "\nThe assigned Doctor: " + doctor +
                "\nThe assigned Nurse: " + nurse + "\n------End of Patient Info------\n";
    }
}