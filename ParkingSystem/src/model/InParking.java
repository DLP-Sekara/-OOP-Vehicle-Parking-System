package model;

import java.time.LocalDateTime;

public class InParking {
    private String vehicleNumber;
    private String vehicleType;
    private int parkingSlot;
    private LocalDateTime parkedTime;

    public InParking() {
    }

    public InParking(String vehicleNumber, String vehicleType, int parkingSlot, LocalDateTime parkedTime) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.parkingSlot = parkingSlot;
        this.parkedTime = parkedTime;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(int parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public LocalDateTime getParkedTime() {
        return parkedTime;
    }

    public void setParkedTime(LocalDateTime parkedTime) {
        this.parkedTime = parkedTime;
    }
}
