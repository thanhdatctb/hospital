package com.assignment.entity.equipment;

public enum EquipmentType {
    HEALTHCARE("Healthcare_Equipments"),
    STAFF("Staff_Equipments");

    private final String text;

    EquipmentType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
