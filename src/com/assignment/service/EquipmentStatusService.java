package com.assignment.service;

import com.assignment.entity.equipment.Equipment;
import com.assignment.entity.equipment.EquipmentType;
import com.assignment.observer.IEquipmentObserver;
import com.assignment.stubdata.EquipmentStubData;

import java.util.ArrayList;
import java.util.List;

public class EquipmentStatusService implements IEquipmentObserver {

    public void occupyEquipments(int quantity, EquipmentType equipmentType) {
        List<Equipment> availableEquipments = getAvailableEquipments(equipmentType);
        int numberOfAvailableEquipments = availableEquipments.size();
        if (numberOfAvailableEquipments > quantity) {
            for (int i = 0; i <= quantity; i++) {
                availableEquipments.get(i).setOccupied(true);
            }
            System.out.println(quantity + " of equipments have been consumed");
        } else {
            System.out.println("There is not enough available equipments to serve the activity!");
        }

    }

    public List<Equipment> getAvailableEquipments(EquipmentType equipmentType) {
        List<Equipment> availableEquipments = new ArrayList<>();
        for (Equipment equipment : EquipmentStubData.equipmentList) {
            if (equipment.getType().equals(equipmentType) && !equipment.isOccupied()) {
                availableEquipments.add(equipment);
            }
        }
        return availableEquipments;
    }


    @Override
    public void updateEquipmentsStatus(int quantity, EquipmentType equipmentType, boolean isComsuming) {
        if (isComsuming) {
            occupyEquipments(quantity, equipmentType);
        } else {
            releaseEquipments(quantity, equipmentType);
        }
    }

    private void releaseEquipments(int quantity, EquipmentType equipmentType) {
        List<Equipment> consumedEquipments = getConsumedEquipments(equipmentType);
        int numberOfConsumedEquipments = consumedEquipments.size();
        if (numberOfConsumedEquipments <= quantity) {
            for (int i = 0; i < quantity; i++) {
                consumedEquipments.get(i).setOccupied(false);
            }
            System.out.println(quantity + " of equipments have been released");
        }
    }

    public List<Equipment> getConsumedEquipments(EquipmentType equipmentType) {
        List<Equipment> consumedEquipments = new ArrayList<>();
        for (Equipment equipment : EquipmentStubData.equipmentList) {
            if (equipment.getType().equals(equipmentType) && equipment.isOccupied()) {
                consumedEquipments.add(equipment);
            }
        }
        return consumedEquipments;
    }


}
