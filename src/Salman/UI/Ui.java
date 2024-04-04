package Salman.UI;

import Salman.Filter.MovieFilter;
import Salman.Model.Movie;
import Salman.Model.User;
import Salman.Services.MovieDatabase;
import Salman.Services.UserServices;
import jdk.swing.interop.SwingInterOpUtils;
import org.apache.poi.ddf.EscherChildAnchorRecord;

import java.util.List;
import java.util.Scanner;

import static Salman.Util.ValidityChecker.isEmailValid;
import static Salman.Util.ValidityChecker.isNameValid;

public class Ui {

    MovieDatabase movieDatabase;
    UserServices userServices ;
    User currUser;
    private Scanner scanner;


    public Ui(MovieDatabase movieDatabase, UserServices userServices, Scanner scanner) {
        this.movieDatabase = movieDatabase;
        this.userServices = userServices;
        this.scanner = scanner;
    }

    public void registerAccount(){
        System.out.println("Enter Your name: ");
        String name = scanner.nextLine();
        if(!isNameValid(name)){
            System.out.println("Invalid name");
            return;
        }
        System.out.println("Enter your email");
        String email = scanner.nextLine();
        if(!isEmailValid(email)){
            System.out.println("Email Invalid");
            return;
        }
        System.out.println("Enter your age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        userServices.registerUser(name,age,email);

    }
    public void displayPersonalInfoWithFavoriteMovies(){
        currUser = userServices.getCurrUser();
        System.out.println("Your name: "+ currUser.getName());
        System.out.println("Your email: "+ currUser.getEmail());
        System.out.println("Your age: "+ currUser.getAge());

        displayYourFavorites();

    }


    public void displayAllMovies(){
        List<Movie> movieList = movieDatabase.getMovieList();
        displayMovies(movieList);
    }

    void displayMovies(List<Movie> movieList){
        int i = 0;
        String choice;
        for(Movie movie: movieList){
            System.out.println(movie.toString());
            i++;
            if(i >= 20 || (movieList.indexOf(movie) + 1) == movieList.size()){
                i = 0;
                System.out.println("Add Movies to your favorites: Y/N?");
                choice = scanner.nextLine();
                if(choice.equalsIgnoreCase("Y")){
                    System.out.println("Enter movie title");
                    choice = scanner.nextLine();
                    Movie dummyMovie = movieDatabase.getMovieFromTitle(choice);
                    try {
                        userServices.getCurrUser().addFavoriteMovie(dummyMovie);
                    }catch (Exception e){
                        System.out.println("Cant add favorite movie");
                    }
                    //displayPersonalInfoWithFavoriteMovies();
                }

                System.out.println("Show more: Y/N ?");
                choice = scanner.nextLine();
                if(choice.equalsIgnoreCase("N")){
                    break;
                }

            }
        }
    }

    public void searchWithType(String type){
        MovieFilter movieFilter = new MovieFilter(type);
        System.out.println("Enter "+type+" of the movie");
        String choice = scanner.nextLine();
        List<Movie> movieList = movieFilter.getFilteredMovie(choice);
        System.out.println("Movies with "+ type+": " + choice);
        displayMovies(movieList);
    }




    public void displayYourFavorites(){
        System.out.println("====>Your Favorite Movies <=====");
        List<Movie> fav = userServices.getCurrUser().getFavoriteMovies();
        for(Movie movie : fav ){
            System.out.println(movie.toString());
        }
        if(fav.isEmpty())
            return;
        System.out.println("Remove Movie From Favorites: Y/N?");
        String choice = scanner.nextLine();
        if(choice.equalsIgnoreCase("Y")){
            System.out.println("Enter Movie Title: ");
            String title = scanner.nextLine();
            Movie movie = new Movie();
            movie.setTitle(title);

            if(fav.contains(movie)){
                userServices.getCurrUser().removeFavoriteMovie(movie);
            }
        }
    }



    public void displayMenu() {
        System.out.println("Welcome to IMDB:");
        System.out.println("1. Create a new account / Log in to your Account");
        System.out.println("2. Display personal Info with favorite movies");
        System.out.println("3. Display all movies");
        System.out.println("4. Display favorite movies");
        System.out.println("5. Search with title");
        System.out.println("6. Search with cast");
        System.out.println("7. Search with category");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");

    }
}
