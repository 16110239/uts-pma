package com.muhamadriza.mycatalogfilm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.muhamadriza.mycatalogfilm.AdapterMovie;
import com.muhamadriza.mycatalogfilm.MovieFilm;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;
    private RecyclerView recyclerView = null;
    private final static String API_KEY = "ddf2799d2cb74830ffa0962a0d4390dc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        connectAndGetApiData();
    }

    public void connectAndGetApiData() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        ApiService apiService = retrofit.create(ApiService.class);
        Call<ApiService> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MovieFilm>() {
            @Override
            public void onResponse(Call<MovieFilm> call, Response<MovieFilm> response) {
                List<MovieFilm> movies = response.body().getResults();
                recyclerView.setAdapter(new AdapterMovie (movies, R.layout.list_movie, getApplicationContext()));
                Log.d(TAG, "Number of movies received: " + movies.size());
            }
            @Override
            public void onFailure(Call<MovieFilm> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });

    }
}