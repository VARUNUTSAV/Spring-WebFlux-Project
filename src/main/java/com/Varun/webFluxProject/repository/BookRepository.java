package com.Varun.webFluxProject.repository;

import com.Varun.webFluxProject.model.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface BookRepository extends ReactiveMongoRepository<Book, Integer> {
    public Flux<Book> findByGenre(String genre);

    public Flux<Book> findByAuthorId(int id);
    public Flux<Book> findByGenreAndCopiesGreaterThan(String genre, int copies);


}
