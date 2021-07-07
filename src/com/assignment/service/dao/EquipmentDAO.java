package com.assignment.service.dao;

import com.assignment.entity.equipment.Equipment;
import com.assignment.entity.equipment.EquipmentType;
import com.assignment.stubdata.EquipmentStubData;

import java.util.ArrayList;
import java.util.List;

public class EquipmentDAO implements IEquipmentDAO{


    public static final String SERVICE_NAME = "EquipmentDAO";

    public int numberOfConsumedEquipments(EquipmentType equipmentType){
        int count = 0;
        for (Equipment e : EquipmentStubData.equipmentList) {
            if(e.isOccupied() || e.getType().equals(equipmentType)){
                count++;
            }
        }
        return count;
    }

    public List<Equipment> getConsumedEquipments(){
        List<Equipment> list = new ArrayList<>();
        for (Equipment e : EquipmentStubData.equipmentList) {
            if(e.isOccupied()){
                list.add(e);
            }
        }
        return list;
    }

    public void addEquipment(int quantity, EquipmentType equipmentType){
        for (int i = EquipmentStubData.equipmentList.size(); i < quantity; i++) {
            EquipmentStubData.equipmentList.add(new Equipment(i, equipmentType.toString(), "Commanded Equipment", equipmentType));
        }
    }
}
