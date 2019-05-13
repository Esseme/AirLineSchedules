package com.airlineschedules.network;

import com.airlineschedules.model.Airport;
import com.airlineschedules.model.Schedule;
import com.airlineschedules.model.Token;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Ed Ssemuwemba on 5/11/19.
 * esseme@gmail.com
 */
public interface AirLineApiInterface {

    @POST("oauth/token")
    Call<Token> getToken(@Header("client_id") String clientId, @Header("client_secret") String clientSecret, @Header("grant_type") String grantType);

    @GET("operations/schedules/{origin}/{destination}/{fromDateTime}[?directFlights=true]")
    Call<List<Schedule>> getSchedules(@Header("access_token") String accessToken);

    @GET("/references/airports/{airportCode}[?lang={languageCode}]")
    Call<Airport> getAirportCord(@Header("access_token") String accesToken);

}
