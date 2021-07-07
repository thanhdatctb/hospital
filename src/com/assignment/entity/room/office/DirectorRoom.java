package com.assignment.entity.room.office;

import com.assignment.entity.floor.MasterFloor;

public class DirectorRoom extends OfficeRoom{
    private static final int DIRECTOR_ROOM_NUMBER = 0;
    private static final String DIRECTOR_ROOM_NAME = "Director Room";

    private static DirectorRoom INSTANCE;

    private DirectorRoom(){
        super(MasterFloor.getINSTANCE(), DIRECTOR_ROOM_NUMBER, 1, DIRECTOR_ROOM_NAME);
    }

    public static DirectorRoom getInstance(){
        if (INSTANCE == null){
            INSTANCE = new DirectorRoom();
        }
        return INSTANCE;
    }

    @Override
    public void setCapacity(int capacity) {
        System.out.println("Director room capacity is set to 1");
    }
}
