package com.example.bootjpa.controller;

import com.example.bootjpa.domain.Movie;
import com.example.bootjpa.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie") //base path API
public class MovieController {

    /**
     * Controller : package untuk menampung controller" dalam pembuatan API
     *
     * Domain : package untuk menampung blueprint object
     *
     * Repository : package untuk data akses ketika menggunakan "Spring data JPA"
     *
     * service : package untuk menampung service" bisnis logic, terdiri dari class interface dan class implementasi.
     *  class interface diperlukan untuk memanage service" yang diinginkan. (IMovie)
     *  class implementasi untuk menuangkan logic sesuai dengan fungsi" pada interface (MovieService)
     */

    /**
     * GetMappng : digunakan untuk keperluan select dan publish data
     * PostMapping : menyimpan data
     * PutMapping : update
     * PatchMapping : update sebagian
     * DeleteMapping : delete
     */

    /*
        @Autowired : untuk (meng-inject/mamanggil/menghidupkan) service yg telah dibuat
        @service : service dari class/object X
        @repository : repo dari class/object X
        @Entity : untuk memberitahu bahwa class tersebut adalah entitas X
     */

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping(value = "all") //localhost:8080/movie/all
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<List<Movie>>(movieService.getMovies(), HttpStatus.OK);
    }

    @PostMapping(value = "create")
    public ResponseEntity add(@RequestBody Movie movie){
        /*
            example :
            method : POST
            path : localhost:8080/movie/create
            content type : JSON(application/json)
            raw body :
            {
              "title" : "Hello Spring"
            }
         */
        movieService.add(movie);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(value = "update/{id}") //localhost:8080/movie/update/{id}
    public ResponseEntity update(@PathVariable Long id, @RequestBody Movie movie){
        /*
            example :
            method : PUT
            path : localhost:8080/movie/update/1
            content type : JSON(application/json)
            raw body :
            {
              "title" : "Hello Spring ABC"
            }
         */
        movieService.updateById(id, movie);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{id}") //localhost:8080/movie/delete/{id}
    public ResponseEntity delete(@PathVariable Long id){
        movieService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}") //localhost:8080/movie/{id}
    public ResponseEntity<Movie> findById(@PathVariable Long id){
        Movie m = movieService.findById(id);
        return new ResponseEntity<Movie>(m, HttpStatus.OK);
    }

}
