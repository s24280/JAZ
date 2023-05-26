package pl.pjwstk.tw.Movie.MovieRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.pjwstk.tw.Movie.Model.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Optional<Movie> findById(int movieId);

    List<Movie> findAll();

    Movie save(Movie movie);

    void deleteById(int movieId);

    @Modifying
    @Query("UPDATE movie SET movie_name = name, movie_category = category WHERE movie_id = id")
    void updateMovie(@Param("id") int movieId, @Param("name") String movieName, @Param("category") String movieCategory);
}
