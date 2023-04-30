package pl.pjwstk.tw.Movie.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjwstk.tw.Movie.Model.Movie;
import pl.pjwstk.tw.Movie.Service.MovieService;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class MovieController {

    private final MovieService movieService;
    public List<Movie> list = new ArrayList<>();

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
        movieService.generateMovieList();
    }

    @GetMapping("/movies")
    ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(movieService.getList());
    }

    @GetMapping("/movies/{id}")
    ResponseEntity<Movie> getMovie(@PathVariable int id) throws FileNotFoundException {
        if (movieService.findMovieById(id) != null) {
            return ResponseEntity.ok(movieService.findMovieById(id));
        }
        throw new FileNotFoundException();
    }

    @PostMapping(path = "movies",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movie> create(@RequestBody Movie newMovie) throws Exception {
        Movie movie = movieService.save(newMovie);
        if(movie == null) {
            throw new Exception();
        } else {
            return new ResponseEntity<>(movie, HttpStatus.CREATED);
        }
    }

    @PutMapping("/movies/{id}")
    ResponseEntity<Movie> update(@RequestBody Movie newMovie) throws Exception {
        if(movieService.findMovieById(newMovie.getId()) == null) {
            throw new Exception();
        }
        else
        {
            movieService.findMovieById(newMovie.getId()).setNameAndCategory(newMovie.getName(), newMovie.getCategory());
            return ResponseEntity.ok(movieService.findMovieById(newMovie.getId()));
        }
    }

    @DeleteMapping("/movies/{id}")
    ResponseEntity<Void> delete(@PathVariable int id) throws FileNotFoundException {
        if(movieService.findMovieById(id) == null) {
            throw new FileNotFoundException();
        }
        else
        {
            movieService.movieList.remove(movieService.findMovieById(id));
            return null;
        }
    }
}