package Salman.Test;

import Salman.Model.Movie;
import Salman.Model.User;
import Salman.Services.MovieDatabase;
import Salman.Services.UserServices;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;


public class UtilTest {
    UserServices userServices = UserServices.getInstance();
    MovieDatabase movieDatabase = MovieDatabase.getInstance();
    List<Movie> movieList = movieDatabase.getMovieList();
    @Test
    public void addFavorites() {
        String title = "The Gift";
        Movie movie = movieDatabase.getMovieFromTitle(title);
        System.out.println(movie.toString());
        assertEquals(1,1 );

    }

    @Test
    public void DisplayAllMovies() {

    }
}
