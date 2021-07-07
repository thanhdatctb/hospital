package com.assignment.entity.employee.humanresource;

public class Director extends HumanResourceEmployee {

    private static final int DIRECTOR_ID = 1;
    public static Director INSTANCE;

    private Director(String name){
        super(DIRECTOR_ID, name);
    }

    public static Director getInstance(String name){
        if(null == INSTANCE){
            INSTANCE = new Director(name);
        }
        return INSTANCE;
    }
}
