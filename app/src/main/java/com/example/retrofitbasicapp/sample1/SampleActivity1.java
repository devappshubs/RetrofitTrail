package com.example.retrofitbasicapp.sample1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.retrofitbasicapp.R;
import com.example.retrofitbasicapp.sample1.adapter.CarDetailsAdapter;
import com.example.retrofitbasicapp.sample1.adapter.CarViewDetailsAdapter;
import com.example.retrofitbasicapp.sample1.adapter.GridLayoutWrapper;
import com.example.retrofitbasicapp.sample1.model1.ScheduleDates;
import com.example.retrofitbasicapp.sample1.model1.ScheduleDatesResp;
import com.example.retrofitbasicapp.sample1.model1.ScheduleDatesVehicle;
import com.example.retrofitbasicapp.sample1.network1.ApiClient;
import com.example.retrofitbasicapp.sample1.network1.ApiInterface;
import com.example.retrofitbasicapp.sample1.network1.Common;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SampleActivity1 extends AppCompatActivity
{
    Button btnRetrofitPostExp;
    LinearLayoutManager linearLayoutManager2;
    RecyclerView recyclerCarData;

    List<ScheduleDatesResp> scheduleDatesRespList;
    ScheduleDatesResp scheduleDatesResp;
    ScheduleDatesVehicle scheduleDatesVehicle;
    CarViewDetailsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample1);

        btnRetrofitPostExp = findViewById(R.id.btnRetrofitPostExp);

        //Car Details
        recyclerCarData = findViewById(R.id.recyclerCarData);

        btnRetrofitPostExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getProjectionDates("2021-11-26T06:54:45.106Z",
//                        "2021-12-08T15:01:01.363Z",
//                        "Pune",
//                        "one-way",
//                        "outstation",
//                        "Premium",
//                        500.0,
//                        "eyJhbGciOiJSUzI1NiIsImtpZCI6IjJlMzZhMWNiZDBiMjE2NjYxOTViZGIxZGZhMDFiNGNkYjAwNzg3OWQiLCJ0eXAiOiJKV1QifQ.eyJuYW1lIjoiTmFiaW5vIENoYW5kcmEgR2lyaSIsInBpY3R1cmUiOiJodHRwOi8vd3d3LmV4YW1wbGUuY29tLzEyMzQ1Njc4L3Bob3RvLnBuZyIsIlJvbGVzIjpbIkRSSVZFUiIsIlVTRVIiXSwiaXNzIjoiaHR0cHM6Ly9zZWN1cmV0b2tlbi5nb29nbGUuY29tL2tpd25pLXBsYXRmb3JtIiwiYXVkIjoia2l3bmktcGxhdGZvcm0iLCJhdXRoX3RpbWUiOjE2Mzc3NTAzMzgsInVzZXJfaWQiOiJVU0VSLWZmOTJjODg5LTI3NWQtNDhjMC1hN2ZlLWE5MmMxODQwY2RmNSIsInN1YiI6IlVTRVItZmY5MmM4ODktMjc1ZC00OGMwLWE3ZmUtYTkyYzE4NDBjZGY1IiwiaWF0IjoxNjM3NzUwMzM4LCJleHAiOjE2Mzc3NTM5MzgsImVtYWlsIjoidGVzdHVzZXIxQGtpd25pLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJwaG9uZV9udW1iZXIiOiIrOTE5NTc5MzY0NzMxIiwiZmlyZWJhc2UiOnsiaWRlbnRpdGllcyI6eyJwaG9uZSI6WyIrOTE5NTc5MzY0NzMxIl0sImVtYWlsIjpbInRlc3R1c2VyMUBraXduaS5jb20iXX0sInNpZ25faW5fcHJvdmlkZXIiOiJwYXNzd29yZCJ9fQ.I4HZBA4TJwwwr_bhr7F-Dudqi1FbqNHqdmpZPJMVCGRCMt_kun6Buctlev7wl-9caHnZ6jLz9gMQN5cW7hQbs0axQL1XKHnW4vsabQ_Ku9ofXbjFFSQX2CDCBHvgXCPdUpWcmpmmDHgb7kJxJZkXN7yqfop0mhJ8jermBksClbO4KC_crAGnG160wWT50dqgETFXkwb7x-oA20y__JsBdEiD1rVDBY5UHkzpjwqG8X5H7NoffPVoj6rgsxLHLJLZgMug88zaOrrY3pnil9mAEHrD8Q60BPLA4pI_3VeatREp0OP8jdwlxHdLDVB6keDG3AbL3So9Jou7PSbKWjRozA");


                getProjectionDates("2021-12-04T06:54:45.106Z",
                        "2021-12-08T15:01:01.363Z",
                        "Pune",
                        "one-way",
                        "outstation",
                        "",
                        500.0,
                        "eyJhbGciOiJSUzI1NiIsImtpZCI6IjJlMzZhMWNiZDBiMjE2NjYxOTViZGIxZGZhMDFiNGNkYjAwNzg3OWQiLCJ0eXAiOiJKV1QifQ.eyJuYW1lIjoiTmFiaW5vIENoYW5kcmEgR2lyaSIsInBpY3R1cmUiOiJodHRwOi8vd3d3LmV4YW1wbGUuY29tLzEyMzQ1Njc4L3Bob3RvLnBuZyIsIlJvbGVzIjpbIkRSSVZFUiIsIlVTRVIiXSwiaXNzIjoiaHR0cHM6Ly9zZWN1cmV0b2tlbi5nb29nbGUuY29tL2tpd25pLXBsYXRmb3JtIiwiYXVkIjoia2l3bmktcGxhdGZvcm0iLCJhdXRoX3RpbWUiOjE2Mzc3NTAzMzgsInVzZXJfaWQiOiJVU0VSLWZmOTJjODg5LTI3NWQtNDhjMC1hN2ZlLWE5MmMxODQwY2RmNSIsInN1YiI6IlVTRVItZmY5MmM4ODktMjc1ZC00OGMwLWE3ZmUtYTkyYzE4NDBjZGY1IiwiaWF0IjoxNjM3NzUwMzM4LCJleHAiOjE2Mzc3NTM5MzgsImVtYWlsIjoidGVzdHVzZXIxQGtpd25pLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJwaG9uZV9udW1iZXIiOiIrOTE5NTc5MzY0NzMxIiwiZmlyZWJhc2UiOnsiaWRlbnRpdGllcyI6eyJwaG9uZSI6WyIrOTE5NTc5MzY0NzMxIl0sImVtYWlsIjpbInRlc3R1c2VyMUBraXduaS5jb20iXX0sInNpZ25faW5fcHJvdmlkZXIiOiJwYXNzd29yZCJ9fQ.I4HZBA4TJwwwr_bhr7F-Dudqi1FbqNHqdmpZPJMVCGRCMt_kun6Buctlev7wl-9caHnZ6jLz9gMQN5cW7hQbs0axQL1XKHnW4vsabQ_Ku9ofXbjFFSQX2CDCBHvgXCPdUpWcmpmmDHgb7kJxJZkXN7yqfop0mhJ8jermBksClbO4KC_crAGnG160wWT50dqgETFXkwb7x-oA20y__JsBdEiD1rVDBY5UHkzpjwqG8X5H7NoffPVoj6rgsxLHLJLZgMug88zaOrrY3pnil9mAEHrD8Q60BPLA4pI_3VeatREp0OP8jdwlxHdLDVB6keDG3AbL3So9Jou7PSbKWjRozA");


            }
        });
    }


    public static Comparator<ScheduleDatesResp> orderBrand = new Comparator<ScheduleDatesResp>() {

//        public int compare(ScheduleDatesResp s1, ScheduleDatesResp s2) {
//
//            String p1 = s1.getVehicle().getBrand();
//            String p2 = s2.getVehicle().getBrand();
//
//            /*For ascending order*/
//            return p1-p2;
//
//            /*For descending order*/
//            //rollno2-rollno1;
//        }
        @Override
        public int compare(ScheduleDatesResp o1, ScheduleDatesResp o2) {
            return o1.getVehicle().getBrand().compareTo(o2.getVehicle().getBrand());
        }


    };



    public void getProjectionDates(String startTime, String endTime, String startLocation,
                                   String direction, String serviceType,
                                   String classType, Double distance, String idToken)
    {
        ApiInterface apiInterface = ApiClient.getClient(ApiClient.PROJECTION_BASE_URL).create(ApiInterface.class);

        ScheduleDates scheduleDates = new ScheduleDates(startTime, endTime, startLocation,
                direction, serviceType, classType, distance);

        Call<List<ScheduleDatesResp>> listCall = apiInterface.getProjectionScheduleDates(scheduleDates, idToken);

        listCall.enqueue(new Callback<List<ScheduleDatesResp>>() {
            @Override
            public void onResponse(Call<List<ScheduleDatesResp>> call, Response<List<ScheduleDatesResp>> response) {
                int statusCode = response.code();
                Log.d("TAG", "statusCode: " + statusCode);
                Log.d("TAG","Response = " + response.toString());
                Log.i("Responsestring", response.body().toString());
                scheduleDatesRespList = response.body();
                recyclerCarData.setHasFixedSize(true);
                recyclerCarData.setLayoutManager(new GridLayoutWrapper(getApplicationContext(), 1));
                ArrayList<String> TempBrandList=new ArrayList<>();


                Collections.sort(scheduleDatesRespList,orderBrand);



                for (int i = 0; i < scheduleDatesRespList.size(); i++)
                {
                    if(!TempBrandList.contains(scheduleDatesRespList.get(i).getVehicle().getBrand())){
                        scheduleDatesRespList.get(i).setViewType(ScheduleDatesResp.LayoutOne);
                        TempBrandList.add(scheduleDatesRespList.get(i).getVehicle().getBrand());
                    }else{
                        scheduleDatesRespList.get(i).setViewType(ScheduleDatesResp.LayoutTwo);
                    }
                }
                adapter = new CarViewDetailsAdapter(getApplicationContext(),scheduleDatesRespList,recyclerCarData);
                recyclerCarData.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ScheduleDatesResp>> call, Throwable t) {
                Log.d("TAG", "error: " + t.toString());
            }
        });
    }
}
