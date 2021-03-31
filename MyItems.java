package com.example.task;

import androidx.annotation.NonNull;

public class MyItems {
    String brand;
    String conYear;
    String icon_image;
    String carType;

    public MyItems(String brand, String conyYear, String carTypa, String icon_image) {
        this.brand = brand;
        this.conYear = conyYear;
        this.icon_image = icon_image;
        this.carType =carTypa;

    }



    public String getCarType(){return carType;}

    public String getBrand() {
        return brand;
    }

    public String getConYear() {
        return conYear;
    }

    public String getIcon_image() {
        return icon_image;
    }



}