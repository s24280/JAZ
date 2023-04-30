package pl.pjwstk.tw.Movie.Service;

import org.springframework.stereotype.Service;
import pl.pjwstk.tw.Movie.Model.Movie;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    public List<Movie> movieList = new ArrayList<>();
    public void generateMovieList() {
        movieList.add(new Movie("abcd", "documental"));
        movieList.add(new Movie("abcdef", "comedy"));
        movieList.add(new Movie("abcdefggh", "drama"));
    }

    public List getList() {
        return movieList;
    }

    public Movie findMovieById(int id) {
        for (Movie movie : movieList) {
            if(movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }
    public Movie findMovieByName(String name) {
        for (Movie movie : movieList) {
            if(movie.getName() == name) {
                return movie;
            }
        }
        return null;
    }

    public Movie save(Movie newMovie) {
        movieList.add(newMovie);
        return newMovie;
    }
}
