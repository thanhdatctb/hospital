package com.assignment.service.dao;

import com.assignment.entity.equipment.Equipment;
import com.assignment.entity.equipment.EquipmentType;

import java.util.List;

public interface IEquipmentDAO {

    public int numberOfConsumedEquipments(EquipmentType equipmentType);
    public List<Equipment> getConsumedEquipments();
    public void addEquipment(int quantity, EquipmentType equipmentType);
}
