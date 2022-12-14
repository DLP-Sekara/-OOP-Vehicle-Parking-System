package controller;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Driver;

import java.util.ArrayList;

public class allDriversController {
    public AnchorPane allDriverTable;
    public TableView<Driver> driverTable;
    public TableColumn dName;
    public TableColumn dNic;
    public TableColumn Dlic;
    public TableColumn dAddress;
    public TableColumn dContact;
    ArrayList<Driver>driverArrayList=new ArrayList();
    {
        driverArrayList.add(new Driver("Sumith Kumara","7835348345V","B6474845","Panadura","0725637456"));
        driverArrayList.add(new Driver("Amila Pathirana","8826253734V","B3354674","Galle","0717573520"));
        driverArrayList.add(new Driver("Jithmal Perera","9283289272V","B3674589","Horana","0772452457"));
        driverArrayList.add(new Driver("Sumith Dissanayaka","9425245373V","B8366399","Kaluthara","0775455213"));
        driverArrayList.add(new Driver("Sumanasiri Herath ","8976544373V","B3537538","Beruwala","0772534436"));
        driverArrayList.add(new Driver("Awantha Fernando ","9173537839V","B3554789","Colombo 5","0714534356"));
        driverArrayList.add(new Driver("Charith Sudara","9573536833V","B6835836","Baththaramulla","0771536662"));
        driverArrayList.add(new Driver("Prashan Dineth","9362426738V","B2683536","Wadduwa","0715353434"));
        driverArrayList.add(new Driver("Chethiya Dilan","9162353436V","B6836836","Panadura","0772436737"));
        driverArrayList.add(new Driver("Dushantha Perera","9255556343V","B3334435","Matara","0777245343"));
        driverArrayList.add(new Driver("Sumith Udayanga   ","8735354355V","B3573783","Galle","0703635442"));
        driverArrayList.add(new Driver("Dinesh Udara  ","9026344373V","B5343783","Hettimulla","0713214255"));
        driverArrayList.add(new Driver("Udana Chathuranga","9692653338V","B7888632","Kottawa","0772442444"));
        driverArrayList.add(new Driver("Mohommad Riaz  ","9124537733V","B3638537","Kaluthara","0777544222"));
        driverArrayList.add(new Driver("Sandun Kumara","9563524267V","B2263333","Panadura","0772325544"));
        driverArrayList.add(new Driver("Priyanga Perera ","9135343537V","B3853753","Matara","0723344562"));
    }
    public void initialize(){
        dName.setCellValueFactory(new PropertyValueFactory("name"));
        dNic.setCellValueFactory(new PropertyValueFactory("nic"));
        Dlic.setCellValueFactory(new PropertyValueFactory("drlnumber"));
        dAddress.setCellValueFactory(new PropertyValueFactory("address"));
        dContact.setCellValueFactory(new PropertyValueFactory("contact"));
        driverTable.setItems(FXCollections.observableArrayList(driverArrayList));

    }
}
