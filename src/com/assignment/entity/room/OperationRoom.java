package com.assignment.entity.room;

import com.assignment.entity.floor.Floor;

public class OperationRoom extends Room{
    public OperationRoom(Floor floor, int number, String name) {
        super(floor, number, -1, name); //-1 means this does not app to have people sit inside
    }
}
