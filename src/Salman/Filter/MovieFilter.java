package Salman.Filter;

import Salman.Model.Movie;
import Salman.Services.MovieDatabase;

import java.util.ArrayList;
import java.util.List;

public class MovieFilter  {

    MovieDatabase movieDatabase = MovieDatabase.getInstance();
    List<Movie> movieList;
    private String type;

    public MovieFilter(String type) {
        this.type = type;
        movieList = movieDatabase.getMovieList();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Movie> getFilteredMovie(String value){
        List<Movie> filteredMovie = new ArrayList<>();
        for(Movie movie : movieList){
            if(type.equalsIgnoreCase("cast") && movie.getCast().equalsIgnoreCase(value)) {
                filteredMovie.add(movie);
            }else if(type.equalsIgnoreCase("category") && movie.getCast().equalsIgnoreCase(value)){
                filteredMovie.add(movie);
            }else if(type.equalsIgnoreCase("title") && movie.getCast().equalsIgnoreCase(value)){
                filteredMovie.add(movie);
            }else{
                //do nothing
            }
        }
        return filteredMovie;
    }







}
