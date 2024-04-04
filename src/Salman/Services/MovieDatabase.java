package Salman.Services;

import Salman.Model.Movie;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MovieDatabase {
    public static volatile MovieDatabase instance;
    private List<Movie> movieList;

    private MovieDatabase(){
        movieList = new ArrayList<>();
        fillUpMovieDatabase();

    }

    public static synchronized  MovieDatabase getInstance(){
        if(instance == null){
            instance = new MovieDatabase();
        }
        return instance;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public Movie getMovieFromTitle(String title){
        Movie dummyMovie = new Movie();
        dummyMovie.setTitle(title);
        int idx = movieList.indexOf(dummyMovie);
        return movieList.get(idx);
    }

    public void sortMovies(){
        Collections.sort(movieList, new Comparator<Movie>() {

            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }

        });
    }

    //add movies from database
    private void fillUpMovieDatabase(){

        try{
            File file = new File("src/Salman/Asset/IMDB_Movie_Database.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();

            itr.next();
            while(itr.hasNext() ){

                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                Movie movie = new Movie();

                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()){
                        case 0:
                            //System.out.println(cell.getStringCellValue());
                            movie.setTitle(cell.getStringCellValue());
                            break;
                        case 1:
                            //System.out.println(cell.getNumericCellValue());
                            DataFormatter dataFormatter = new DataFormatter();
                            String value = dataFormatter.formatCellValue(cell);
                            movie.setReleaseDate(value);
                            break;
                        case 2:
                            //System.out.println(cell.getStringCellValue());
                            movie.setCategory(cell.getStringCellValue());
                            break;
                        case 3:
                            //System.out.println(cell.getStringCellValue());
                            movie.setCast(cell.getStringCellValue());
                            break;
                        case 4:
                            //System.out.println(cell.getNumericCellValue());
                            movie.setBudget(cell.getNumericCellValue());
                    }
                }
                movieList.add(movie);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        sortMovies();

    }

}
