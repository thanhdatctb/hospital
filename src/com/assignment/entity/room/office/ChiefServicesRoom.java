package com.assignment.entity.room.office;

import com.assignment.entity.floor.Floor;

public class ChiefServicesRoom extends OfficeRoom
{
    public ChiefServicesRoom(Floor floor, int number, String name) {
        super(floor, number, 2, name);
    }

    @Override
    public void setCapacity(int capacity) {
        if(capacity > 0 && capacity <= 2){
            super.setCapacity(capacity);
        } else {
            System.out.println("The Chiefs of Services Room can contain max 2 people");
        }
    }
}
