package com.assignment.stubdata;

import com.assignment.entity.equipment.Equipment;
import com.assignment.entity.equipment.EquipmentType;

import java.util.ArrayList;
import java.util.List;

public class EquipmentStubData {
    public static List<Equipment> equipmentList = new ArrayList<>();

    static {
        equipmentList.add(new Equipment(1, "Equipment-1", "This is for healthcare service", EquipmentType.HEALTHCARE));
        equipmentList.add(new Equipment(2, "Equipment-2", "This is for healthcare service", EquipmentType.HEALTHCARE));
        equipmentList.add(new Equipment(3, "Equipment-3", "This is for healthcare service", EquipmentType.HEALTHCARE));
        equipmentList.add(new Equipment(4, "Equipment-4", "This is for healthcare service", EquipmentType.STAFF));
        equipmentList.add(new Equipment(5, "Equipment-5", "This is for healthcare service", EquipmentType.STAFF));
        equipmentList.add(new Equipment(6, "Equipment-6", "This is for healthcare service", EquipmentType.STAFF));
    }
}
