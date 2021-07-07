package com.assignment.entity.floor;

/**
 * This single floor for HR and Director
 */
public class MasterFloor extends Floor{

    public static final int MASTER_FLOOR_NUMBER = 0; //0 represent the ground floor
    public static final String MASTER_FLOOR_NAME = "Master Floor";

    private MasterFloor() {
        super(MASTER_FLOOR_NUMBER, MASTER_FLOOR_NAME);
    }

    private static MasterFloor INSTANCE;

    public static MasterFloor getINSTANCE(){
        if (null == INSTANCE){
            INSTANCE = new MasterFloor();
        }
        return INSTANCE;
    }
}
