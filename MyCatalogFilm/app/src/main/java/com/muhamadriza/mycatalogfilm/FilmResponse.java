package com.muhamadriza.mycatalogfilm;

import java.util.List;

/**
 * Created by Muhamad Riza on 10/30/2018.
 */

public class FilmResponse {

    @SerializedName("results")
    private List<MovieFilm> results;

    public List<MovieFilm> getResults() {
        return results;
    }


}
