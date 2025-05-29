package com.collectionssample;

import com.collectionssample.models.City;
import com.collectionssample.models.Country;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class CollectionsController {

    @FXML
    private ComboBox<Country> cmbCountry; // ülkeler

    @FXML
    private  ComboBox<City> cmbCities; // ülkesine göre şehirler

    @FXML
    private ListView<Country> lstDetails; // Country bilgisini liste oalrak tutar


    @FXML
    void initialize() {
        // Comboboxları nesneler ile doldurma kısmı

        Country c = new Country();
        c.setName("United States");

        City c1 = new City();
        c1.setName("Newyork");
        c1.setPlateCode("NYC");
        c1.setCountry(c);
        // country oluşuncaki aşamada addCity
        c.addCity(c1);

        System.out.println(c);

    }

    public void onCountryChange() {

    }

    public void onCityChange() {

    }

    public void onSave() {
        // Combo içinden seçilenleri ListBox aktar
    }
}
