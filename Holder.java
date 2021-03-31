package com.example.task;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Holder {
    View row;
    TextView car_Type;
    TextView brand;
    TextView counstruction_Year;
    ImageView carImage;

    public Holder(View v) {
        this.row = v;
    }

    public TextView getCarType() {
        if (car_Type ==null)
        {
            car_Type =row.findViewById(R.id.car_type_Value);
        }
        return car_Type;
    }

    public TextView get_brand() {
        if (brand ==null)
        {
            brand =row.findViewById(R.id.brand_Value);
        }
        return brand;
    }

    public ImageView get_carImage() {
        if (carImage ==null)
        {
            carImage =row.findViewById(R.id.car_image);
        }
        return carImage;
    }
    public TextView get_counstruction_Year() {
        if (counstruction_Year ==null)
        {
            counstruction_Year =row.findViewById(R.id.counstruction_Year_Value);
        }
        return counstruction_Year;
    }



}

