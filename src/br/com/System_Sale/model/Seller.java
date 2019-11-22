package br.com.System_Sale.model;

import java.io.Serializable;
import java.util.List;

public class Seller extends Employee implements Serializable {

    private String individualRegistration; //CPF
    private String identityDocument; //RG

    public Seller() {
        type = "Vendedor";
    }

    public Seller(String individualRegistration, String identityDocument,Integer id, String type, String name, String email, String phone) {
        super(id, "Vendedor", name, email, phone);
        this.individualRegistration = individualRegistration;
        this.identityDocument = identityDocument;
    }

    public String getIndividualRegistration() {
        return individualRegistration;
    }

    public void setIndividualRegistration(String individualRegistration) {
        this.individualRegistration = individualRegistration;
    }

    public String getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
