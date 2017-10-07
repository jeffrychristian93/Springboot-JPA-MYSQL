package com.example.bootjpa.service;

import com.example.bootjpa.domain.Movie;

import java.util.List;

public interface IMovieService {

    void add(Movie movie);
    void updateById(Long id, Movie movie);
    void deleteById(Long id);
    List<Movie> getMovies();
    Movie findById(Long id);

}
