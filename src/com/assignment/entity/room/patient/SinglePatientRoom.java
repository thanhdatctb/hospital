package com.assignment.entity.room.patient;

import com.assignment.entity.floor.Floor;

public class SinglePatientRoom extends PatientRoom{
    public SinglePatientRoom(Floor floor, int number, String name) {
        super(floor, number, 1, name);
    }

    @Override
    public void setCapacity(int capacity) {
        if(capacity == 1){
            super.setCapacity(capacity);
        } else {
            System.out.println("The double patient room can contain only 1 patient");
        }
    }
}
