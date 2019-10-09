package ru.lanit.demodb.dto;

public class AddressDto {

    private int id;

    private String city;

    private String street;

    private String house;

    private int flat;

    public AddressDto(int id, String city, String street, String house, int flat) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", город: " + city +
                ", улица: " + street +
                ", дом: " + house +
                ", квартира: " + flat;
    }
}
