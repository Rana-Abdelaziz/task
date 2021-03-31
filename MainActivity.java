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
    View v;
    Vector myitems = new  Vector<MyItems>();
    boolean check=false;
    ArrayAdapter my_adpter;
    JsonApi jsonApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List_view=findViewById(R.id.car_details);
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        myitems.add(new MyItems("Bmw","2015","used","R.drawable.ic_android_black_24dp"));

        my_adpter = new Array_adapter(this, R.layout.customeview, R.id.title, myitems);
        List_view.setAdapter(my_adpter);
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("http://demo1585915.mockable.io/api/v1/cars?page={page}")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
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
                    return;
                }
                List<Car>cars=response.body();
                for(Car car:cars){
                    String Content="";
                    String brand=car.getBrand();
                    String year=car.getConYear();
                    String used=car.getIsused();
                    String imgUrl=car.getImgUrl();
                    myitems.add(new MyItems(brand,year,used,imgUrl));


                }
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {

                Log.d("d", "faluier");
            }
        });
    }
}