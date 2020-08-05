package com.esmaeel.examples;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    String BASE_URL = "https://jsonplaceholder.typicode.com/";
    Retrofit retrofit;

    public ApiManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public WebService getMyService() {
        return retrofit.create(WebService.class);
    }


}