package com.example.retrofitbasicapp.sample1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofitbasicapp.R;

public class SampleActivity2 extends AppCompatActivity
{
    Button btnRetrofitPostExp;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample1);

        btnRetrofitPostExp = findViewById(R.id.btnRetrofitPostExp);
        btnRetrofitPostExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*getProjectionDates("2021-11-26T06:54:45.106Z",
                        "2021-12-08T15:01:01.363Z",
                        "Pune",
                        "one-way",
                        "outstation",
                        "Premium",
                        500.0,
                        "eyJhbGciOiJSUzI1NiIsImtpZCI6IjJlMzZhMWNiZDBiMjE2NjYxOTViZGIxZGZhMDFiNGNkYjAwNzg3OWQiLCJ0eXAiOiJKV1QifQ.eyJuYW1lIjoiTmFiaW5vIENoYW5kcmEgR2lyaSIsInBpY3R1cmUiOiJodHRwOi8vd3d3LmV4YW1wbGUuY29tLzEyMzQ1Njc4L3Bob3RvLnBuZyIsIlJvbGVzIjpbIkRSSVZFUiIsIlVTRVIiXSwiaXNzIjoiaHR0cHM6Ly9zZWN1cmV0b2tlbi5nb29nbGUuY29tL2tpd25pLXBsYXRmb3JtIiwiYXVkIjoia2l3bmktcGxhdGZvcm0iLCJhdXRoX3RpbWUiOjE2Mzc3NTAzMzgsInVzZXJfaWQiOiJVU0VSLWZmOTJjODg5LTI3NWQtNDhjMC1hN2ZlLWE5MmMxODQwY2RmNSIsInN1YiI6IlVTRVItZmY5MmM4ODktMjc1ZC00OGMwLWE3ZmUtYTkyYzE4NDBjZGY1IiwiaWF0IjoxNjM3NzUwMzM4LCJleHAiOjE2Mzc3NTM5MzgsImVtYWlsIjoidGVzdHVzZXIxQGtpd25pLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJwaG9uZV9udW1iZXIiOiIrOTE5NTc5MzY0NzMxIiwiZmlyZWJhc2UiOnsiaWRlbnRpdGllcyI6eyJwaG9uZSI6WyIrOTE5NTc5MzY0NzMxIl0sImVtYWlsIjpbInRlc3R1c2VyMUBraXduaS5jb20iXX0sInNpZ25faW5fcHJvdmlkZXIiOiJwYXNzd29yZCJ9fQ.I4HZBA4TJwwwr_bhr7F-Dudqi1FbqNHqdmpZPJMVCGRCMt_kun6Buctlev7wl-9caHnZ6jLz9gMQN5cW7hQbs0axQL1XKHnW4vsabQ_Ku9ofXbjFFSQX2CDCBHvgXCPdUpWcmpmmDHgb7kJxJZkXN7yqfop0mhJ8jermBksClbO4KC_crAGnG160wWT50dqgETFXkwb7x-oA20y__JsBdEiD1rVDBY5UHkzpjwqG8X5H7NoffPVoj6rgsxLHLJLZgMug88zaOrrY3pnil9mAEHrD8Q60BPLA4pI_3VeatREp0OP8jdwlxHdLDVB6keDG3AbL3So9Jou7PSbKWjRozA");*/
            }
        });
    }

    public void getProjectionDates()
    {

    }
}
