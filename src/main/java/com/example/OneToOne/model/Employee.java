package com.example.OneToOne.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "designation")
    private String designation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_address", referencedColumnName = "id")
    private EmployeeAddress address;


    public Employee(String name, String designation,EmployeeAddress address) {
        this.name = name;
        this.designation = designation;
        this.address = address;
    }

    public Employee(){}



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public EmployeeAddress getAddress() {
        return address;
    }

    public void setAddress(EmployeeAddress address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", address=" + address +
                '}';
    }
}
