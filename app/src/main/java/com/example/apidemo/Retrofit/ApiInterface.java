package com.example.apidemo.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface
{
    @GET(Const.GENER)
    Call<GenereResponse> getGener();
}
