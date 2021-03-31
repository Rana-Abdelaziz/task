package com.example.task;

import com.google.gson.annotations.SerializedName;

public class Car {

     @SerializedName("brand")
     String brand;
     @SerializedName("constractionYear")
     String conYear;
     @SerializedName("isUsed")
     Boolean isused;

     public String getImgUrl() {
          return imgUrl;
     }

     @SerializedName("imageUrl")
     String imgUrl;

     public Car(String brandd, String consYear, boolean used) {
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

     public boolean getIsused() {
          return isused;
     }
}
