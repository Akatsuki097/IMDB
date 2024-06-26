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
    @Test
    public void addFavorites() {
        String title = "The Gift";
        Movie movie = movieDatabase.getMovieFromTitle(title);
        userServices.registerUser("Salman",12,"a@gmail.com");
        userServices.getCurrUser().addFavoriteMovie(movie);
        assertEquals(true,userServices.getCurrUser().getFavoriteMovies().contains(movie) == true );

    }


}
