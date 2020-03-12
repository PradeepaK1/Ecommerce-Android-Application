package com.example.ptljdf;

public class Product {

    private String name;
    private String temperatureDay;
    private String temperatureNight;
    private String pH;
    private String humidity;
    private String ec;
    private int image;

    public Product(String name, String temperatureDay, String temperatureNight, String pH, String humidity, int image) {
        this.name = name;
        this.temperatureDay = temperatureDay;
        this.temperatureNight = temperatureNight;
        this.pH = pH;
        this.humidity = humidity;
        this.ec = ec;
        this.image = image;
    }

    public String getName() {
        return name;
    }
    public String getTemperatureDay() {
        return temperatureDay;
    }
    public String getTemperatureNight() {
        return temperatureNight;
    }

    public String getpH() {
        return pH;
    }
    public String getHumidity() {
        return humidity;
    }
    public String getEc() {
        return ec;
    }

    public int getImage() {
        return image;
    }
}