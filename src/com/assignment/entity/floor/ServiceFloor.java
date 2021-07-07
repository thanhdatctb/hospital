package com.assignment.entity.floor;

import com.assignment.entity.service.Service;

public class ServiceFloor extends Floor{

    public ServiceFloor(int number, String name, Service service) {
        super(number, name);
        this.service = service;
        if(service != null){
            this.service.setFloor(this);
        }
    }
}
