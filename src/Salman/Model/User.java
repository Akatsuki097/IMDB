package Salman.Model;

import java.util.List;

public class User {
    private String name;
    private int age;
    private String email;
    private List<Movie> favoriteMovies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Movie> getFavoriteMovies() {
        return favoriteMovies;
    }


}