package com.example.retrofitbasicapp.sample1.network1;

import com.example.retrofitbasicapp.sample1.model1.ScheduleDates;
import com.example.retrofitbasicapp.sample1.model1.ScheduleDatesResp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface
{
    String GOOGLE_MAP_API_KEY = "AIzaSyCC3Tk24iI-IU8SvXkzDUj2i2mBeFjw3-s";

    @POST("/api/schedules/dates/")
    Call<List<ScheduleDatesResp>>
    getProjectionScheduleDates(@Body ScheduleDates scheduleDates,
                               @Header("Authorization") String idToken);
}
