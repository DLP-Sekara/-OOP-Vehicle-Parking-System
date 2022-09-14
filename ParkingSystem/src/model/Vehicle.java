package model;

import controller.addDriverController;
import controller.onDeliveryTableController;

import java.time.LocalDateTime;

public class Vehicle {
    private String vehicleNumber;
    private String vehicleType;
    private int maximumWeight;
    private int numberOfPassengers;
    private String driverNic;

    public Vehicle() {
    }

    public Vehicle(String vehicleNumber, String vehicleType, int maximumWeight, int numberOfPassengers, String driverNic) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.maximumWeight = maximumWeight;
        this.numberOfPassengers = numberOfPassengers;
        this.driverNic = driverNic;
    }

    public void park(String vehicleNumber,String vehicleType){

    }
    public void leavePark(String vehicleNumber,String vehicleType){
        String driverName=null;
        for (Driver driver: addDriverController.driverArrayList
             ) {
            if(this.getDriverNic().equalsIgnoreCase(driver.getNic())){
                driverName=driver.getName();
            }
        }
        OnDelivery onDelivery=new OnDelivery(vehicleNumber,vehicleType,driverName, LocalDateTime.now());
        onDeliveryTableController.onDeliveries.add(onDelivery);
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

    public int getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(int maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getDriverNic() {
        return driverNic;
    }

    public  void setDriverNic(String driverNic) {
        this.driverNic = driverNic;
    }
}

