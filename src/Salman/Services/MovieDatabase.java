package Salman.Services;

import Salman.Model.Movie;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    //add movies from database
    private void fillUpMovieDatabase(){

        try{
            File file = new File("src/Salman/Asset/IMDB_Movie_Database.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            int i = 0;
            itr.next();
            while(itr.hasNext() && i++ < 20){

                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                Movie movie = new Movie();

                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()){
                        case 0:
                            System.out.println(cell.getStringCellValue());
                            movie.setTitle(cell.getStringCellValue());
                            break;
                        case 1:
                            System.out.println(cell.getNumericCellValue());
                            DataFormatter dataFormatter = new DataFormatter();
                            String value = dataFormatter.formatCellValue(cell);
                            movie.setReleaseDate(value);
                            break;
                        case 2:
                            System.out.println(cell.getStringCellValue());
                            movie.setCategory(cell.getStringCellValue());
                            break;
                        case 3:
                            System.out.println(cell.getStringCellValue());
                            movie.setCast(cell.getStringCellValue());
                            break;
                        case 4:
                            System.out.println(cell.getNumericCellValue());
                            movie.setBudget(cell.getNumericCellValue());
                    }
                }
                movieList.add(movie);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("ggs");
    }

}
