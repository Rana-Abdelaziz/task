package com.example.task;

import com.google.gson.annotations.SerializedName;

public class Car {

     @SerializedName("body")
     String brand;
     @SerializedName("title")
     String conYear;
     @SerializedName("userId")
     String isused;

     public String getImgUrl() {
          return imgUrl;
     }

     @SerializedName("imageUrl")
     String imgUrl;

     public Car(String brandd, String consYear, String used) {
          brand = brandd;
          conYear = consYear;
          isused = used;
     }



     public String getBrand() {
          return brand;
     }

     public String getConYear() {
          return conYear;
     }

     public String getIsused() {
          return isused;
     }
}
