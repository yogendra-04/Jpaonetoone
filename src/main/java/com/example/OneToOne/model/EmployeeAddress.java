package com.example.OneToOne.model;



import javax.persistence.*;

@Entity
public class EmployeeAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "street_name")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode")
    private int pin;

    public EmployeeAddress(String street, String city, int pin) {

        this.street = street;
        this.city = city;
        this.pin = pin;
    }
    public EmployeeAddress(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", pin=" + pin +
                '}';
    }
}
