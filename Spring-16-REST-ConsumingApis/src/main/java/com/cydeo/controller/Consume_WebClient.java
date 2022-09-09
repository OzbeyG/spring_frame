package com.cydeo.controller;

import com.cydeo.entity.Genre;
import com.cydeo.entity.MovieCinema;
import com.cydeo.repository.GenreRepository;
import com.cydeo.repository.MovieCinemaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Consume_WebClient {

    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();

    private final MovieCinemaRepository movieCinemaRepository;
    private final GenreRepository genreRepository;

    public Consume_WebClient(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
    }

    @GetMapping("/flux-movie-cinemas")//Flux for multiple
    public Flux<MovieCinema> readAllCinemaFlux(){
        return Flux.fromIterable(movieCinemaRepository.findAll());
    }

//    @GetMapping("/mono-movie-cinema/{id}")//Mono for single or none
//    private Mono<MovieCinema> readById(@PathVariable("id") Long id){
//        return Mono.just(movieCinemaRepository.findById(id).get());
//    }

    //Sample  of above with ResponseEntity
    @GetMapping("/mono-movie-cinema/{id}")//Mono for single or none
    private ResponseEntity<Mono<MovieCinema>> readById(@PathVariable("id") Long id){
        return ResponseEntity.ok(Mono.just(movieCinemaRepository.findById(id).get()));
    }

    @PostMapping("/create-genre")
    public Mono<Genre> createGenre(@RequestBody Genre genre){

        Genre createdGenre = genreRepository.save(genre);

        return Mono.just(createdGenre);

        //return Mono.just(genreRepository.save(genre));
    }

    //Return empty after delete
    @DeleteMapping("/delete-genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable("id") Long id){
        genreRepository.deleteById(id);

        return Mono.empty();
    }



    //---------------WebClient------------------------//

    @GetMapping("/flux") //Consuming WebClient in reactive way from above created endpoint
    public Flux<MovieCinema> readWithWebClient(){
        return webClient
                .get()
                .uri("/flux-movie-cinemas")  //End-point of above  GetMapping
                .retrieve()
                .bodyToFlux(MovieCinema.class);
    }


    @GetMapping("/mono/{id}")
    public Mono<MovieCinema> readMonoWithWebClient(@PathVariable("id") Long id){
        return webClient
                .get()
                .uri("/mono-movie-cinema/{id}", id)
                .retrieve()
                .bodyToMono(MovieCinema.class);
    }
}
