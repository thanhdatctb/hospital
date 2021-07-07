package com.assignment.entity.room;

import com.assignment.entity.floor.Floor;

public class StorageRoom extends Room{
    public StorageRoom(Floor floor, int number, String name) {
        super(floor, number, -1, name); // -1 means that this room does not aim to have people sit inside
    }
}
