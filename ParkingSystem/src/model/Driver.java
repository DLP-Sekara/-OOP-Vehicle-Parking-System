package model;

public class Driver {
    private String name;
    private String nic;
    private String drlNumber;
    private String address;
    private String contact;

    public Driver() {
    }

    public Driver(String name, String nic, String drlNumber, String address, String contact) {
        this.name = name;
        this.nic = nic;
        this.drlNumber = drlNumber;
        this.address = address;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDrlnumber() {
        return drlNumber;
    }

    public void setDrlnumber(String drlnumber) {
        this.drlNumber = drlnumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


}
