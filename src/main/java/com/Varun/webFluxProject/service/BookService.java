package com.Varun.webFluxProject.service;

import com.Varun.webFluxProject.model.Book;
import com.Varun.webFluxProject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;

    public Flux<Book> getAllBooks() { return bookRepository.findAll(); }

    public Flux<Book> getBooksByGenre(String genre){ return bookRepository.findByGenre(genre); }

    public Flux<Book> getBooksByGenreAndCopies(String genre, int copies){
        return bookRepository.findByGenreAndCopiesGreaterThan(genre, copies);
    }

    public Flux<Book> getBooksByAuthorId(int id) { return bookRepository.findByAuthorId(id);}

    public Flux<Book> getBooksByAuthor(String authorName){
        return authorService
                .getAuthorByName(authorName)
                .flatMapMany(author -> bookRepository.findByAuthorId(author.getId()));
    }

    public Mono<Book> postBook(Book book){ return bookRepository.save(book);}
}
