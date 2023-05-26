package pl.pjwstk.tw.Movie.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pjwstk.tw.Movie.Model.Movie;
import pl.pjwstk.tw.Movie.MovieRepository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(int movieId) {
        return movieRepository.findById(movieId);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(int movieId, String movieName, String movieCategory) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            movie.setMovieName(movieName);
            movie.setMovieCategory(movieCategory);
            return movieRepository.save(movie);
        }
        return null;
    }

    public boolean deleteMovie(int movieId) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isPresent()) {
            movieRepository.deleteById(movieId);
            return true;
        }
        return false;
    }
}