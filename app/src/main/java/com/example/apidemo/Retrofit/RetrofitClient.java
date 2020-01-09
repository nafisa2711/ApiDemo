package com.example.apidemo.Retrofit;

import com.example.apidemo.Retrofit.Const;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;

     public static Retrofit getClient()
    {
        if (retrofit==null)
        {
            HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder http = new OkHttpClient.Builder();
            http.connectTimeout(2,TimeUnit.MINUTES);
            http.readTimeout(1,TimeUnit.MINUTES);
            http.writeTimeout(1,TimeUnit.MINUTES);
            http.addInterceptor(interceptor);

            retrofit=new Retrofit.Builder()
                    .baseUrl(Const.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(http.build())
                    .build();
        }
        return retrofit;
    }
}
