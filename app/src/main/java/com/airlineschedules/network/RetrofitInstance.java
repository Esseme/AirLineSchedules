package com.airlineschedules.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ed Ssemuwemba on 5/11/19.
 * esseme@gmail.com
 */
public class RetrofitInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.lufthansa.com/v1/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retrofit;
    }


}
