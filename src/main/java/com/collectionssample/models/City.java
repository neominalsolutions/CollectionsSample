package com.collectionssample.models;

public class City {
    private String name;
    private String plateCode;
    // Her şehrin sadece bir ülkesi vardır ilişkisi
    private Country country; // bir nenseye başka bir nesne referans verdik

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(String plateCode) {
        this.plateCode = plateCode;
    }
}
