
package br.com.System_Sale.model;

import java.io.Serializable;
import java.util.List;


public class Manager extends Employee implements Serializable{
    
    private String numberBook;
    private String typeRole; //CARGO

    public Manager() {
        type = "Gerente";
    }

    public Manager(String numberBook, String typeRole, Integer id, String type, String name, String email, String phone) {
        super(id, "Gerente", name, email, phone);
        this.numberBook = numberBook;
        this.typeRole = typeRole;
    }

    public String getNumberBook() {
        return numberBook;
    }

    public void setNumberBook(String numberBook) {
        this.numberBook = numberBook;
    }

    public String getTypeRole() {
        return typeRole;
    }

    public void setTypeRole(String typeRole) {
        this.typeRole = typeRole;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    
    
    
    
    
}
