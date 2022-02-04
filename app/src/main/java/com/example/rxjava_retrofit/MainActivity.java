package com.example.rxjava_retrofit;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private MainAdapter mainAdapter;
    MainDataViewModel mainDataViewModel;
    RecyclerView re_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainDataViewModel = ViewModelProviders.of(this).get(MainDataViewModel.class);
        mainDataViewModel.refresh();

        re_1 = (RecyclerView) findViewById(R.id.re_1);
        observeViewModel();

    }

    public void observeViewModel() {
        mainDataViewModel.mainArrayList.observe(this, mainData -> {
            Log.d("livedataTest", mainData.get(4).toString());
            mainAdapter = new MainAdapter(mainData, this);
            re_1.setAdapter(mainAdapter);
        });

        mainDataViewModel.toastMassage.observe(this, s -> {
            if (s != null) Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
            else Toast.makeText(this, "아직 값 없음", Toast.LENGTH_SHORT).show();
        });
    }
}