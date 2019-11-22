package br.com.System_Sale.model;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable {

    protected Integer id;
    protected String type;
    protected String name;
    protected String email;
    protected String phone;
    protected Address address;

    public Employee() {
        
    }

    public Employee(Integer id, String type, String name, String email, String phone) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
