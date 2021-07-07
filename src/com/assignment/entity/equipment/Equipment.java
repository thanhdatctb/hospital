package com.assignment.entity.equipment;

public class Equipment {
    int id;
    String name;
    String description;
    EquipmentType type;
    boolean isOccupied;

    public Equipment(int id, String name, String description, EquipmentType type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.isOccupied = false;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public EquipmentType getType() {
        return type;
    }
}
