package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView List_view;
    Vector myitems = new  Vector<MyItems>();
    ArrayAdapter my_adpter;
    JsonApi jsonApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List_view=findViewById(R.id.car_details);
        my_adpter = new Array_adapter(this, R.layout.customeview, R.id.title, myitems);
        List_view.setAdapter(my_adpter);
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("http://demo1585915.mockable.io/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonApi=retrofit.create(JsonApi.class);
        getPosts();
    }
    void getPosts(){

        Call<List<Car>> call=jsonApi.getPosts(1);
        call.enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                if(!response.isSuccessful()){
                    Log.d("d", "success");
                    return;
                }
                List<Car>cars=response.body();
                for(Car car:cars){
                    String brand=car.getBrand();
                    String year=car.getConYear();
                    boolean used=car.getIsused();
                    String isUsed;
                    if(used==true){
                        isUsed= "Used";
                    }else {
                        isUsed="New";
                    }
                    String imgUrl=car.getImgUrl();
                    myitems.add(new MyItems(brand,year,isUsed,imgUrl));


                }
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {

                Log.d("d", "faluier");
            }
        });
    }
}