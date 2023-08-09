package com.example.instructordetailsprocject.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "adress")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "pincode")
    private int pincode;


    public AddressEntity() {
    }

    public AddressEntity(String address, int pincode) {
        this.address = address;
        this.pincode = pincode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}
