package com.example.rxjava_retrofit;

import java.util.List;

import io.reactivex.Single;

public interface MainDataApi {
    Single<List<MainData>> getMainData();
}
