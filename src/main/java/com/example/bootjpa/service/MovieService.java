package com.example.bootjpa.service;

import com.example.bootjpa.domain.Movie;
import com.example.bootjpa.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService{

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void add(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void updateById(Long id, Movie movie) {
        Movie result = movieRepository.getOne(id);
        result.setTitle(movie.getTitle());
        movieRepository.save(result);
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).get();
    }
}
