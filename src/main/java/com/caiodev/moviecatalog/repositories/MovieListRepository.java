package com.caiodev.moviecatalog.repositories;

import com.caiodev.moviecatalog.entities.Movie;
import com.caiodev.moviecatalog.entities.MovieList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieListRepository extends JpaRepository<MovieList, Long> {
}
