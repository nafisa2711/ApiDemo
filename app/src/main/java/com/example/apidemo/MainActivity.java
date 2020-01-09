package com.example.apidemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.apidemo.Retrofit.ApiInterface;
import com.example.apidemo.Retrofit.GenerAdapter;
import com.example.apidemo.Retrofit.GenereListResponse;
import com.example.apidemo.Retrofit.GenereResponse;
import com.example.apidemo.Retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btn_apiresponse,btn_sqllite;
    RecyclerView rv_cartlist;
    ApiInterface apiInterface;
    List<GenereListResponse> genereListResponses;
    Context context;
    GenerAdapter generAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        btn_apiresponse = findViewById(R.id.btn_apiresponse);
        btn_sqllite = findViewById(R.id.btn_sqllite);
        rv_cartlist = findViewById(R.id.rv_cartlist);

        btn_apiresponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getgenersApi();
            }
        });
        btn_sqllite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SqlliteActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getgenersApi() {
        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
        Call<GenereResponse> genereResponseCall = apiInterface.getGener();

        genereResponseCall.enqueue(new Callback<GenereResponse>() {
            @Override
            public void onResponse(Call<GenereResponse> call, Response<GenereResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals(1)) {
                        genereListResponses = response.body().getData();
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                        rv_cartlist.setLayoutManager(linearLayoutManager);
                        generAdapter = new GenerAdapter(context,genereListResponses);
                        rv_cartlist.setAdapter(generAdapter);
                        Log.d("mytag", "list size::::" + genereListResponses.size());
                    }
                }
            }

            @Override
            public void onFailure(Call<GenereResponse> call, Throwable throwable) {

            }
        });
    }
}
