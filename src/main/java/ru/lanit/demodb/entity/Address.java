package ru.lanit.demodb.entity;

import javax.persistence.*;

@Entity
@Table(name = "address", schema = "db_test")
public class Address {

    private int id;
    private int peopleId;
    private String city;
    private String street;
    private String house;
    private int flat;

    public Address() {

    }

    public Address(int peopleId, String city, String street, String house, int flat) {
        this.peopleId = peopleId;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "people_id")
    public int getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(int peopleId) {
        this.peopleId = peopleId;
    }

    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "house")
    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Column(name = "flat")
    @Basic(optional = true)
    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }
}
