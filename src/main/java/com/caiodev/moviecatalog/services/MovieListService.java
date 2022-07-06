package com.caiodev.moviecatalog.services;

import com.caiodev.moviecatalog.dto.MovieDTO;
import com.caiodev.moviecatalog.dto.MovieListDTO;
import com.caiodev.moviecatalog.entities.Movie;
import com.caiodev.moviecatalog.entities.MovieList;
import com.caiodev.moviecatalog.entities.Profile;
import com.caiodev.moviecatalog.repositories.MovieListRepository;
import com.caiodev.moviecatalog.repositories.MovieRepository;
import com.caiodev.moviecatalog.services.exceptions.DatabaseException;
import com.caiodev.moviecatalog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MovieListService {

    @Autowired
    MovieListRepository repository;

    @Autowired
    MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Page<MovieListDTO> findAllPaged(Pageable pageable) {
        Page<MovieList> page = repository.findAll(pageable);
        return page.map(x -> new MovieListDTO(x));
    }

    @Transactional(readOnly = true)
    public MovieListDTO findById(Long id) {
        Optional<MovieList> obj = repository.findById(id);
        MovieList entity = obj.orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));
        return new MovieListDTO(entity);
    }

    @Transactional
    public MovieListDTO insert(MovieListDTO dto) {
        MovieList entity = new MovieList();
        copyEntityToDto(entity, dto);
        entity = repository.save(entity);
        return new MovieListDTO(entity);
    }

    @Transactional
    public MovieListDTO update(MovieListDTO dto, Long id) {
        try {
            MovieList entity = repository.getOne(id);
            copyEntityToDto(entity, dto);
            entity = repository.save(entity);
            return new MovieListDTO(entity);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Id not found: " + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation!");
        }
    }

    private void copyEntityToDto(MovieList entity, MovieListDTO dto) {
        entity.setTitle(dto.getTitle());
        entity.setProfile(new Profile(dto.getProfileId(), null, null));

        entity.getMovies().clear();

        for (MovieDTO movieDTO : dto.getMovies()) {
            Movie movie = movieRepository.getOne(movieDTO.getId());
            entity.getMovies().add(movie);
        }
    }


}
