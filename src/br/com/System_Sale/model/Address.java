package br.com.System_Sale.model;

public class Address {

    private Integer id;
    private String road;
    private String neighborhood; // BAIRRO (VIZINHANÇA)
    private String city;
    private String state;

    public Address() {

    }

    public Address(Integer id, String road, String neighborhood, String city, String state) {
        this.id = id;
        this.road = road;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
