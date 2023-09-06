package com.Varun.webFluxProject.repository;

import com.Varun.webFluxProject.model.Author;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AuthorRepository extends ReactiveMongoRepository<Author, String> {

    public Mono<Author> findByName(String name);
    public Flux<Author> findByNameRegex(String nameRegex);
}
