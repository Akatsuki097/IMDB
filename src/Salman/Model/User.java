package Salman.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private int age;
    private String email;
    private List<Movie> favoriteMovies;

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
        favoriteMovies = new ArrayList<>();
    }
    public void removeFavoriteMovie(Movie movie){
        favoriteMovies.remove(movie);
    }

    public String getName() {
        return name;
    }

    public void addFavoriteMovie(Movie movie){
        favoriteMovies.add(movie);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return email.equalsIgnoreCase( user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
