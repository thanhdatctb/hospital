package com.assignment.entity.room.patient;

import com.assignment.entity.floor.Floor;
import com.assignment.entity.room.Room;

public class PatientRoom extends Room {
    public PatientRoom(Floor floor, int number, int capacity, String name) {
        super(floor, number, capacity, name);
    }
}
