package com.collectionssample.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Country {
    private String name;
    private Set<City> cities; // ülkenin içerisinde birden fazla şehir vardır. Aynı şehir referansı yanlışlıkla listeye eklenemesin

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void addCity(City city) {
        if(cities == null) {
            cities = new HashSet<>();
        }

        cities.add(city);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
