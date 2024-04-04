package Salman;

import Salman.Filter.MovieFilter;
import Salman.Model.Movie;
import Salman.Model.User;
import Salman.Services.MovieDatabase;
import Salman.Services.UserServices;
import Salman.UI.Ui;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;

import java.util.List;
import java.util.Scanner;

public class MovieListingApplicaton {
    public static void main(String[] args) {
        //MovieDatabase movieDatabase =  MovieDatabase.getInstance();
        //UserServices userServices = UserServices.getInstance();
        //MovieFilter movieFilter = new MovieFilter("cast");
        //List<Movie> list = movieFilter.getFilteredMovie("Ryan Reynolds");


        Scanner scanner ;
        int choice;
        UserServices userServices = UserServices.getInstance();
        MovieDatabase movieDatabase = MovieDatabase.getInstance();

        Ui userInterface = new Ui(movieDatabase, userServices,new Scanner(System.in));

        do{
            userInterface.displayMenu();
            scanner = new Scanner(System.in);

            choice = scanner.nextInt();
            scanner.nextLine();

            try{
                switch (choice){
                    case 1:
                        userInterface.registerAccount();
                        break;
                    case 2:
                        userInterface.displayPersonalInfoWithFavoriteMovies();
                        break;
                    case 3:
                        userInterface.displayAllMovies();
                        break;
                    case 4:
                        userInterface.displayYourFavorites();
                        break;
                    case 5:
                        userInterface.searchWithType("title");
                        break;
                    case 6:
                        userInterface.searchWithType("cast");
                        break;
                    case 7:
                        userInterface.searchWithType("category");
                        break;
                    default:
                        System.out.println("Invalid Choices!");
                }
            }catch (Exception e){

            }


        }while(choice != 8);


        System.out.println("finish");

    }
}
