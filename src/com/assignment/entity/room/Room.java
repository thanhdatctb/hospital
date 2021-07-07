package com.assignment.entity.room;

import com.assignment.entity.floor.Floor;

public abstract class Room {
    Floor floor;
    int number;
    int capacity;
    String name;

    public Room(Floor floor, int number, int capacity, String name) {
        this.floor = floor;
        this.number = number;
        setCapacity(capacity);
        this.name = name;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Room{" +
                "floor=" + floor +
                ", number=" + number +
                ", capacity=" + capacity +
                ", name='" + name + '\'' +
                '}';
    }
}
