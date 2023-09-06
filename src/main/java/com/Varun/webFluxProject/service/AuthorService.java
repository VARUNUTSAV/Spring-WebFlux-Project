package com.Varun.webFluxProject.service;

import com.Varun.webFluxProject.model.Author;
import com.Varun.webFluxProject.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Mono<Author> postAuthor(Author author) { return authorRepository.save(author); }

    public Mono<Author> getAuthorByName(String name) { return authorRepository.findByName(name); }

    public Flux<Author> getAuthorByNameRegex(String name) { return authorRepository.findByNameRegex(name);}

}
