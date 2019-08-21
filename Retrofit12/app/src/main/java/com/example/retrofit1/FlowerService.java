package com.example.retrofit1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlowerService {
    @GET("feeds/flowers.json")
    Call<List<FowerResponse>> getAllFlowers();
}
