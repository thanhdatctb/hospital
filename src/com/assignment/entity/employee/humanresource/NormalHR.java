package com.assignment.entity.employee.humanresource;

import com.assignment.entity.service.Service;

public class NormalHR extends HumanResourceEmployee{
    Service service;

    public NormalHR(int id, String name) {
        super(id, name);
    }
}
