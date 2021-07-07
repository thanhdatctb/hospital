package com.assignment.entity.patient;

public enum DiseaseType {
    MEDICAL("Medical_Type"),
    OPERATION("Operation_Type");

    private final String text;

    DiseaseType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
