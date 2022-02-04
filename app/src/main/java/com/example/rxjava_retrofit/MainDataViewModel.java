package com.example.rxjava_retrofit;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;

public class MainDataViewModel extends ViewModel {
//    public MainDataService mainDataService = MainDataService.getInstance();
//
//    // os에 의해 앱의 프로세스가 죽거는 등의 상황에서
//    // Single 객체를 가로채기 위함
//    private CompositeDisposable disposable = new CompositeDisposable();
//
//    private void fetchCountries(){
//        // 서버로부터 데이터를 받아오는 동안에 로딩 스피너를 보여주기 위함
//        loading.setValue(true);
//        disposable.add(MainDataService.getMainData()
//                //.subscribeWith(Scheduler.newThread())
//                .subscribeWith(Scheduler.)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new DisposableSingleObserver<List<MainData>>(){
//                    @Override
//                    public void onSuccess(@NonNull List<MainData> mainDataList) {
//
//                    }
//                }));
//    }
    public ArrayList<MainData> Mainarraylist;


}
