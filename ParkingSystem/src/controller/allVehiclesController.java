package controller;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Vehicle;

import java.util.ArrayList;

public  class  allVehiclesController {
    public AnchorPane allVehicleTable;
    public  TableView<Vehicle> vTable;
    public TableColumn vNumber;
    public TableColumn vType;
    public TableColumn vWeight;
    public TableColumn vPassenger;
    public  ArrayList<Vehicle>vehicleArrayList=new ArrayList();
    {
        vehicleArrayList.add(new Vehicle("NA-3434","Bus",3500,60 ,null));
        vehicleArrayList.add(new Vehicle("KA-4563","Van",1000,7 ,null));
        vehicleArrayList.add(new Vehicle("58-3567 ","Van",1500,4 ,null));
        vehicleArrayList.add(new Vehicle("GF-4358","Van",800,4 ,null));
        vehicleArrayList.add(new Vehicle("CCB-3568","Van",1800,8 ,null));
        vehicleArrayList.add(new Vehicle("LM-6679","Van",1500,4 ,null));
        vehicleArrayList.add(new Vehicle("QA-3369","Van",1800,6 ,null));
        vehicleArrayList.add(new Vehicle("KB-3668","Cargo Lorry",2500,2 ,null));
        vehicleArrayList.add(new Vehicle("JJ-9878","Cargo Lorry",3000,2 ,null));
        vehicleArrayList.add(new Vehicle("GH-5772","Cargo Lorry",4000,3 ,null));
        vehicleArrayList.add(new Vehicle("XY-4456","Cargo Lorry",3500,2 ,null));
        vehicleArrayList.add(new Vehicle("YQ-3536","Cargo Lorry",2000,2 ,null));
        vehicleArrayList.add(new Vehicle("CBB-3566","Cargo Lorry",2500,2 ,null));
        vehicleArrayList.add(new Vehicle("QH-3444 ","Cargo Lorry",5000,4 ,null));
    }

    public void initialize(){
        vNumber.setCellValueFactory(new PropertyValueFactory("vehicleNumber"));
        vType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        vWeight.setCellValueFactory(new PropertyValueFactory("maximumWeight"));
        vPassenger.setCellValueFactory(new PropertyValueFactory("numberOfPassengers"));
     vTable.setItems(FXCollections.observableArrayList(vehicleArrayList));
        
    }
}
