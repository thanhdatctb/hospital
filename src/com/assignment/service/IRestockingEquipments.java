package com.assignment.service;

import com.assignment.entity.equipment.EquipmentType;

public interface IRestockingEquipments {
   void doRestock();
   void takeRestockInfo(int quantity, EquipmentType type);
}
