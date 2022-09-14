package model;

import controller.inParkingTableController;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Bus extends Vehicle {
    public static ArrayList<Integer>reservedSlotsBus=new ArrayList<>();
    static {
        reservedSlotsBus.add(14);
    }

    public Bus() {
    }

    public Bus(String vehicleNumber, String vehicleType, int maximumWeight, int numberOfPassengers, String driverNic) {
        super(vehicleNumber, vehicleType, maximumWeight, numberOfPassengers, driverNic);
    }

    @Override
    public void park(String vehicleNumber, String vehicleType) {
        super.park(vehicleNumber, vehicleType);
        int slot=parkingSlot();
        InParking inParking=new InParking(vehicleNumber,vehicleType,slot,LocalDateTime.now());
        inParkingTableController.inParkingList.add(inParking);
    }
    private int parkingSlot() {
        ArrayList<Integer> slotsArray = new ArrayList<>();
        if (!inParkingTableController.inParkingList.isEmpty()) {
            for (InParking vehicleInParking : inParkingTableController.inParkingList) {
                for (int slot : reservedSlotsBus) {
                    if (vehicleInParking.getParkingSlot() == slot) {
                        slotsArray.add(slot);
                        break;
                    }
                }
            }
        } else {
            return reservedSlotsBus.get(0);
        }

        for (int slot : reservedSlotsBus) {
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
