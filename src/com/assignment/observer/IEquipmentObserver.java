package com.assignment.observer;

import com.assignment.entity.equipment.EquipmentType;

public interface IEquipmentObserver {
    void updateEquipmentsStatus(int quantity, EquipmentType equipmentType, boolean isComsuming);
}
