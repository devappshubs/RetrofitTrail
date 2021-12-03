package com.example.retrofitbasicapp.sample1.network1;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient
{
    public static final String SIGN_UP_BASE_URL = "https://security-7qkkocxieq-el.a.run.app/";
    public static final String PROJECTION_BASE_URL = "https://projection-api-7qkkocxieq-el.a.run.app/";
    private static Retrofit retrofit = null;

    /*public static Retrofit getClient()
    {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }*/

    public static Retrofit getClient(String BASE_URL)
    {
        if (retrofit==null)
        {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            // set your desired log level
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.connectTimeout(100, TimeUnit.SECONDS);
            httpClient.readTimeout(100,TimeUnit.SECONDS);
            // add your other interceptors …
            // add logging as last interceptor
            httpClient.addInterceptor(logging)  // <-- this is the important line!
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }
}
