package com.assignment.entity.room.office;

import com.assignment.entity.floor.Floor;

public class HumanResourcesRoom extends OfficeRoom{
    public HumanResourcesRoom(Floor floor, int number, String name) {
        super(floor, number, 3, name);
    }

    @Override
    public void setCapacity(int capacity) {
        if(capacity > 0 && capacity <= 3){
            super.setCapacity(capacity);
        } else {
            System.out.println("The Human Resources Room can contain max 3 people");
        }
    }
}
