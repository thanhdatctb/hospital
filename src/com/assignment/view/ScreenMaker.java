package com.assignment.view;

public class ScreenMaker {
    private IFacadeScreen facadeScreen;

    public void showChiefActivitiesScreen(){
        facadeScreen = new ChiefActivitiesScreen();
        facadeScreen.show();
    }

    public void showDoctorActivitiesScreen(){
        facadeScreen = new DoctorActivitiesScreen();
        facadeScreen.show();
    }

    public void showHRActivitiesScreen(){
        facadeScreen = new HRActivitiesScreen();
        facadeScreen.show();
    }

    public void showStaffActivitiesScreen(){
        facadeScreen = new StaffActivitiesScreen();
        facadeScreen.show();
    }

    public void showDirectortivitiesScreen(){
        facadeScreen = new DirectorActivitiesScreen();
        facadeScreen.show();
    }
}
