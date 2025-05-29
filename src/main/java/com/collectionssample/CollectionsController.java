package com.collectionssample;

import com.collectionssample.models.City;
import com.collectionssample.models.Country;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.util.HashSet;
import java.util.Set;


public class CollectionsController {

    @FXML
    private ComboBox<Country> cmbCountry; // ülkeler

    @FXML
    private  ComboBox<City> cmbCity; // ülkesine göre şehirler

    @FXML
    private ListView<Country> lstDetails; // Country bilgisini liste olarak tutar


    @FXML
    void initialize() {
        // Comboboxları nesneler ile doldurma kısmı

        Country country1 = new Country();
        country1.setName("United States");


        City c1 = new City();
        c1.setName("Newyork");
        c1.setPlateCode("NYC");
        c1.setCountry(country1);

        City c2 = new City();
        c2.setName("San francisco");
        c2.setPlateCode("SF");
        c2.setCountry(country1);
        // country oluşuncaki aşamada addCity
        country1.addCity(c1);
        country1.addCity(c2);


        Country country2 = new Country();
        country2.setName("Türkiye");


        City c3 = new City();
        c3.setName("İstanbul");
        c3.setPlateCode("34");
        c3.setCountry(country2);

        City c4 = new City();
        c4.setName("Ankara");
        c4.setPlateCode("06");
        c4.setCountry(country2);


        City c5 = new City();
        c5.setName("İzmir");
        c5.setPlateCode("35");
        c5.setCountry(country2);

        // country oluşuncaki aşamada addCity
        country2.addCity(c3);
        country2.addCity(c4);
        country2.addCity(c5);

        // Boxing
        cmbCountry.getItems().addAll(country1,country2);

    }

    // Country ComboxBox seçiminde seçilen Country Billgisinden Cityleri CmbCity yükledik.
    public void onCountryChange() {

        // combox seçilen birşey varsa
        if(cmbCountry.getSelectionModel().getSelectedItem() != null) {

            // unboxing
          Country c =   (Country)cmbCountry.getSelectionModel().getSelectedItem();

          cmbCity.getItems().clear(); // eski verileri temizle

          Set<City> cities = new HashSet<>(c.getCities());
          // seçilen ülkeye göre combobox city ile doldu.
            cmbCity.getItems().addAll(cities);
        }

    }

    public void onCityChange() {
    }

    public void onSave() {

        // Unboxing
        Country c = cmbCountry.getSelectionModel().getSelectedItem();

        if(c != null) {
            lstDetails.getItems().addAll(c);
        }

    }

    // Listview eklenen nesneler üzerinden alert olarak detayını gösterdik.
    public void onItemSelect() {
        // Listviewde seçilen bilgileri unboxing yap. Alert ile göster
        if(lstDetails.getSelectionModel().getSelectedItem() != null) {
            Country c = lstDetails.getSelectionModel().getSelectedItem();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Ülke Seçim");
            alert.setHeaderText("Seçilen Ülkeye Ait Şehir Sayısı "+ c.getCities().size());
            alert.showAndWait();

        }
    }
}
