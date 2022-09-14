package model;

import java.time.LocalDateTime;

public class OnDelivery {
    private String vehicleNumber;
    private String vehicleType;
    private String driverName;
    private LocalDateTime leftTime;

    public OnDelivery() {
    }

    public OnDelivery(String vehicleNumber, String vehicleType, String driverName, LocalDateTime leftTime) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.driverName = driverName;
        this.leftTime = leftTime;
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

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public LocalDateTime getLeftTime() {
        return leftTime;
    }

    public void setLeftTime(LocalDateTime leftTime) {
        this.leftTime = leftTime;
    }
}
