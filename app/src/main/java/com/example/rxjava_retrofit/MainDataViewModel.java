package com.example.rxjava_retrofit;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainDataViewModel extends ViewModel {

    public MainDataService mainDataService = MainDataService.getInstance();

    public MutableLiveData<List<MainData>> mainArrayList = new MutableLiveData<>();
    public MutableLiveData<String> toastMassage = new MutableLiveData<>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<>();


    // os에 의해 앱의 프로세스가 죽거는 등의 상황에서
    // Single 객체를 가로채기 위함
    private CompositeDisposable disposable = new CompositeDisposable();

    public void refresh() {
        fetchCountries();
    }

    private void fetchCountries() {
        //로딩 데이터를 보여줌일단
        //서버로부터 데이터를 받아오는 동안에 로딩 스피너를 보여주기 위함
        loading.setValue(true);
        //disposable 메모리 관리 해주는 것
        //메모리 할당 add로 즉 레트로핏에서 가져온 데이터를 넣어줍니다.
        disposable.add(mainDataService.getMainData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(
                        new DisposableSingleObserver<List<MainData>>() {

                            @Override
                            public void onSuccess(List<MainData> mainData) {
                                mainArrayList.setValue(mainData);
                                //데이터를 성공적 통신해서 받으면 로딩끝
                                loading.setValue(false);
//                                Log.d("livedataTest2", mainArrayList.getValue().toString());
                            }

                            @Override
                            public void onError(Throwable e) {
//                                Log.d("livedataTest3", mainArrayList.toString());
                                //통신에 실패하면 로딩끝 실패 토스트메세지 발송
                                loading.setValue(false);
                                toastMassage.setValue("실패");
                            }
                        }
                ));

    }


    @Override
    protected void onCleared() {
        disposable.clear();
        super.onCleared();
    }
}
