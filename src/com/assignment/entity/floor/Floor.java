package com.assignment.entity.floor;

import com.assignment.entity.service.Service;

public abstract class Floor {
    int number;
    String name;
    Service service;

    protected Floor(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
