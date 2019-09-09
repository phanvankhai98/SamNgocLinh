package com.pvkhaicd.samngoclinh.Model.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    //api fake on mock api
    public static final String BASE_URL = "https://5d725e905acf5e0014730dec.mockapi.io/api/";
    private static Retrofit sRetrofitClient = null;

    public static Retrofit getClient() {
        if (sRetrofitClient == null) {
            sRetrofitClient = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofitClient;
    }

    private RetrofitClient() {
    }
}
