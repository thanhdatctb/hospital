package com.assignment.entity.room.patient;

import com.assignment.entity.floor.Floor;

public class DoublePatientsRoom extends PatientRoom{

    public DoublePatientsRoom(Floor floor, int number, String name) {
        super(floor, number, 2, name);
    }

    @Override
    public void setCapacity(int capacity) {
        if(capacity > 0 && capacity <= 2){
            super.setCapacity(capacity);
        } else {
            System.out.println("The double patient room can contain max 2 people");
        }
    }
}
