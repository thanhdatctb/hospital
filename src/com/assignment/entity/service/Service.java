package com.assignment.entity.service;

import com.assignment.entity.floor.Floor;

public class Service {
    int id;
    String serviceName;
    Floor floor;

    public Service(int id, String serviceName) {
        this.id = id;
        this.serviceName = serviceName;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}
