package com.muhamadriza.mycatalogfilm;

/**
 * Created by Muhamad Riza on 10/30/2018.
 */

public interface ApiService {
    @GET("movie/now_playing")
    Call<FilmResponse> getTopRatedMovies(@Query("api_key") String apiKey);
}
