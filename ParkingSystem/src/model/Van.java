package model;
import controller.inParkingTableController;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Van extends Vehicle {
    public static ArrayList<Integer>reservedSlotsVan=new ArrayList<>();
    static {
        reservedSlotsVan.add(1);
        reservedSlotsVan.add(2);
        reservedSlotsVan.add(3);
        reservedSlotsVan.add(4);
        reservedSlotsVan.add(12);
        reservedSlotsVan.add(13);
    }

    public Van() {
    }

    public Van(String vehicleNumber, String vehicleType, int maximumWeight, int numberOfPassengers, String driverNic) {
        super(vehicleNumber, vehicleType, maximumWeight, numberOfPassengers, driverNic);
    }

    @Override
    public void park(String vehicleNumber, String vehicleType) {
        super.park(vehicleNumber, vehicleType);
        int slot=parkingSlot();
        InParking inParking=new InParking(vehicleNumber,vehicleType,slot,LocalDateTime.now());
        //System.out.println(inParking);
        inParkingTableController.inParkingList.add(inParking);
    }
    public static int parkingSlot() {
         ArrayList<Integer> slotsArray = new ArrayList<>();

        if (!inParkingTableController.inParkingList.isEmpty()) {
            for (InParking vehicleInParking : inParkingTableController.inParkingList) {
                for (int slot : reservedSlotsVan) {
                    if (vehicleInParking.getParkingSlot() == slot) {
                        slotsArray.add(slot);
                        break;
                    }
                }
            }
        } else {
            return reservedSlotsVan.get(0);
        }
        for (int slot : reservedSlotsVan) {
            if (!slotsArray.contains(slot)) {
                return slot;
            }
        }

        return -1;
    }

    @Override
    public void leavePark(String vehicleNumber, String vehicleType) {
        super.leavePark(vehicleNumber, vehicleType);
       // OnDelivery onDelivery=new OnDelivery(vehicleNumber,vehicleType,this.getDriverNic(), LocalDateTime.now());
        //onDeliveryTableController.onDeliveries.add(onDelivery);

    }
}
