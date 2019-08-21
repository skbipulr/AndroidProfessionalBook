package com.example.retrofit1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    FlowerService flowerService;
    private ListView listView;
    FlowerAdapter flowerAdapter;
    List<FowerResponse> flowers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);


         flowerService = RetrofitInstance.getRetrofit().create(FlowerService.class);
         Call<List<FowerResponse>> call = flowerService.getAllFlowers();
         call.enqueue(new Callback<List<FowerResponse>>() {
             @Override
             public void onResponse(Call<List<FowerResponse>> call, Response<List<FowerResponse>> response) {
                  flowers = response.body();
                // Log.e(TAG,"Total Size:"+flowers.size());
                 flowerAdapter = new FlowerAdapter(MainActivity.this,flowers);
                 listView.setAdapter(flowerAdapter);
             }

             @Override
             public void onFailure(Call<List<FowerResponse>> call, Throwable t) {

             }
         });

    }
}
