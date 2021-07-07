package com.assignment.service;

import com.assignment.entity.equipment.EquipmentType;
import com.assignment.factory.ServicesFactory;
import com.assignment.service.dao.EquipmentDAO;

public class RestockEquipmentsService implements IRestockingEquipments{

    private final EquipmentDAO equipmentDAO;

    public RestockEquipmentsService() {
        this.equipmentDAO = ServicesFactory.getService(EquipmentDAO.SERVICE_NAME);
    }

    public static final String SERVICE_NAME = "RestockEquipmentsService";
    int restockQuantity;
    EquipmentType restockEquipmentType;


    @Override
    public void doRestock() {
        equipmentDAO.addEquipment(restockQuantity, restockEquipmentType);
        System.out.println(restockQuantity + " equipments has been restocked");
    }

    @Override
    public void takeRestockInfo(int quantity, EquipmentType type) {
        this.restockQuantity = quantity;
        this.restockEquipmentType = type;
    }
}
