package com.example.task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonApi {




    @GET("cars/{page}")
    Call<List<Car>>getPosts(@Path("page") int Pagetid
    );


}
