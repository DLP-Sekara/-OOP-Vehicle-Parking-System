package model;

import controller.inParkingTableController;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CargoLorry extends Vehicle {
    public static ArrayList<Integer>reservedSlotsLorry=new ArrayList<>();
    static {
        reservedSlotsLorry.add(5);
        reservedSlotsLorry.add(6);
        reservedSlotsLorry.add(7);
        reservedSlotsLorry.add(8);
        reservedSlotsLorry.add(9);
        reservedSlotsLorry.add(10);
        reservedSlotsLorry.add(11);
    }

    public CargoLorry() {
    }

    public CargoLorry(String vehicleNumber, String vehicleType, int maximumWeight, int numberOfPassengers, String driverNic) {
        super(vehicleNumber, vehicleType, maximumWeight, numberOfPassengers, driverNic);
    }

    @Override
    public void park(String vehicleNumber, String vehicleType) {
        super.park(vehicleNumber, vehicleType);
        int slot=parkingSlot();
        InParking inParking=new InParking(vehicleNumber,vehicleType,slot,LocalDateTime.now());
        System.out.println(inParking);
        inParkingTableController.inParkingList.add(inParking);
    }
    private int parkingSlot() {
        ArrayList<Integer> slotsArray = new ArrayList<>();

        if (!inParkingTableController.inParkingList.isEmpty()) {
            for (InParking vehicleInParking : inParkingTableController.inParkingList) {
                for (int slot : reservedSlotsLorry) {
                    if (vehicleInParking.getParkingSlot() == slot) {
                        slotsArray.add(slot);
                        break;
                    }
                }
            }
        } else {
            return reservedSlotsLorry.get(0);
        }

        for (int slot : reservedSlotsLorry) {
            if (!slotsArray.contains(slot)) {
                return slot;
            }
        }

        return -1;
    }

    @Override
    public void leavePark(String vehicleNumber, String vehicleType) {
        super.leavePark(vehicleNumber, vehicleType);
        //OnDelivery onDelivery=new OnDelivery(vehicleNumber,vehicleType,this.getDriverNic(), LocalDateTime.now());
        //onDeliveryTableController.onDeliveries.add(onDelivery);
    }
}
