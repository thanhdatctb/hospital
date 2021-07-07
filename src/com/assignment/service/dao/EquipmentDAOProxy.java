package com.assignment.service.dao;

import com.assignment.entity.equipment.Equipment;
import com.assignment.entity.equipment.EquipmentType;

import java.util.List;

public class EquipmentDAOProxy implements IEquipmentDAO{
    public static final String SERVICE_NAME = "EquipmentDAOProxy";
    private EquipmentDAO equipmentDAO = new EquipmentDAO();

    @Override
    public int numberOfConsumedEquipments(EquipmentType equipmentType) {
        return equipmentDAO.numberOfConsumedEquipments(equipmentType);
    }

    @Override
    public List<Equipment> getConsumedEquipments() {
        return equipmentDAO.getConsumedEquipments();
    }

    @Override
    public void addEquipment(int quantity, EquipmentType equipmentType) {
         equipmentDAO.addEquipment(quantity, equipmentType);
    }
}
