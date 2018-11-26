package com.example.vi_ni.augustmark.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "ADDRESS_TABLE",
        foreignKeys =
        @ForeignKey(entity = Store.class, parentColumns = "IDSTORE", childColumns = "IDSTORE_FK"))
public class Address {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "IDADDRESS")
    private Integer idAddress;

    @ColumnInfo(name = "COUNTRY")
    private String country;

    @ColumnInfo(name = "STATE")
    private String state;

    @ColumnInfo(name = "CITY")
    private String city;

    @ColumnInfo(name = "STREET")
    private String street;

    @ColumnInfo(name = "DISTRICT")
    private String district;

    @ColumnInfo(name = "NUM")
    private Integer num;

    @ColumnInfo(name = "IDSTORE_FK")
    private Integer idStore;

    public Address(){}

    public Address(Integer idAddress, String country, String state, String city, String street, String district, Integer num){
        this.idAddress = idAddress;
        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
        this.district = district;
        this.num = num;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getDistrict() {
        return district;
    }

    public Integer getNum() {
        return num;
    }

    public Integer getIdStore() {
        return idStore;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setIdStore(Integer idStore) {
        this.idStore = idStore;
    }
}
