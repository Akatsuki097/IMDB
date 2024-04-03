package Salman.Util;

import Salman.Model.Movie;

import java.util.List;

public class MovieSearchingType {
    protected String type;
    protected List<Movie> movieList;

    public MovieSearchingType(String type, List<Movie> movieList){
        this.type = type;
        this.movieList = movieList;
    }

//    public static Cast cast(String type, List<Movie> movieList){
//        return new Cast(type, movieList);
//    }

    public List<Movie> getMovieList() {
        return movieList;
    }

}
