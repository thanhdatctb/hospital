package com.assignment.stubdata;

import com.assignment.entity.floor.Floor;
import com.assignment.entity.floor.MasterFloor;
import com.assignment.entity.floor.ServiceFloor;
import com.assignment.entity.room.OperationRoom;
import com.assignment.entity.room.Room;
import com.assignment.entity.room.StorageRoom;
import com.assignment.entity.room.office.ChiefServicesRoom;
import com.assignment.entity.room.office.DirectorRoom;
import com.assignment.entity.room.office.HumanResourcesRoom;
import com.assignment.entity.room.patient.DoublePatientsRoom;
import com.assignment.entity.room.patient.SinglePatientRoom;
import com.assignment.entity.service.Service;

import java.util.ArrayList;
import java.util.List;

public class BuildingStubData {
    public static List<Floor> floorList = new ArrayList<>();
    public static List<Room> roomList = new ArrayList<>();
    public static List<Service> serviceList = new ArrayList<>();



    static {

        //Prepare some services
        Service emergency = new Service(1, "Emergency");
        Service geriatric = new Service(2, "Geriatric");
        Service pediatric = new Service(3, "Pediatric");
        serviceList.add(emergency);
        serviceList.add(geriatric);
        serviceList.add(pediatric);


        //prepare some existing floors

        //only one floor for Director and HR
        floorList.add(MasterFloor.getINSTANCE());
        //a floor for emergency
        floorList.add(new ServiceFloor(1, "Emergency", emergency));
        //a floor for geriatric
        floorList.add(new ServiceFloor(2, "Geriatric", geriatric));
        //a floor for pediatric
        floorList.add(new ServiceFloor(3, "Pediatric", pediatric));


        //prepare some existing rooms in the floors

        //rooms in the ground floor
        roomList.add(DirectorRoom.getInstance());
        roomList.add(new HumanResourcesRoom(floorList.get(0), 1, "Human Resource Room"));
        roomList.add(DirectorRoom.getInstance());

        //rooms in the 1st floor
        roomList.add(new ChiefServicesRoom(floorList.get(1), 1, "Chief of Emergency Service"));
        roomList.add(new StorageRoom(floorList.get(1), 2, "Emergency - Storage"));
        roomList.add(new OperationRoom(floorList.get(1), 2, "Emergency - Operation - 1"));
        roomList.add(new OperationRoom(floorList.get(1), 3, "Emergency - Operation - 2"));
//        roomList.add(new SinglePatientRoom(floorList.get(1), 1, "Emergency - Single Patient"));
//        roomList.add(new DoublePatientsRoom(floorList.get(1), 1, "Emergency - Double Patients"));

        //rooms in the 2dn floor
        roomList.add(new ChiefServicesRoom(floorList.get(2), 1, "Chief of Geriatric Service"));
        roomList.add(new StorageRoom(floorList.get(2), 2, "Geriatric - Storage"));
        roomList.add(new OperationRoom(floorList.get(2), 2, "Geriatric - Operation"));
        roomList.add(new SinglePatientRoom(floorList.get(2), 1, "Geriatric - Single Patient"));
        roomList.add(new DoublePatientsRoom(floorList.get(2), 1, "Geriatric - Double Patients"));

        //rooms in the 3rd floor
        roomList.add(new ChiefServicesRoom(floorList.get(3), 1, "Chief of Pediatric Service"));
        roomList.add(new StorageRoom(floorList.get(3), 2, "Pediatric - Storage"));
        roomList.add(new OperationRoom(floorList.get(3), 2, "Pediatric - Operation"));
        roomList.add(new SinglePatientRoom(floorList.get(3), 1, "Pediatric - Single Patient"));
        roomList.add(new DoublePatientsRoom(floorList.get(3), 1, "Pediatric - Double Patients"));
    }
}
