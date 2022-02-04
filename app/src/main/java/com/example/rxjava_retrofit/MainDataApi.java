package com.example.rxjava_retrofit;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface MainDataApi {

    @GET("/posts")
    Single<List<MainData>> getMainData();
}
