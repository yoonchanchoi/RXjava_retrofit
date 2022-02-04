package com.example.rxjava_retrofit;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainDataService {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private static MainDataService instance;

    public MainDataApi api = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(MainDataApi.class);

    public static MainDataService getInstance() {
        if (instance == null) {
            instance = new MainDataService();
        }
        return instance;
    }

    public Single<List<MainData>> getMainData() {
        return api.getMainData();
    }
}
