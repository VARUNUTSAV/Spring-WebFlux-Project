package com.Varun.webFluxProject.controller;

import com.Varun.webFluxProject.model.Author;
import com.Varun.webFluxProject.model.Book;
import com.Varun.webFluxProject.service.AuthorService;
import com.Varun.webFluxProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @GetMapping("/allBooks")
    public Flux<Book> getAllBooks(){ return bookService.getAllBooks();}

    @GetMapping("/book/Genre")
    public Flux<Book> getBooksByGenre(@RequestParam String genre){
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping("/book/Genre/Copies")
    public Flux<Book> getBooksByGenreAndCopies(@RequestParam String genre, @RequestParam int copies){
        return bookService.getBooksByGenreAndCopies(genre, copies);
    }

    @PostMapping("/post/Book")
    public Mono<Book> postBook(@RequestBody @Valid Book book) { return bookService.postBook(book); }

    @PostMapping("/post/Author")
    public Mono<Author> postAuthor(@RequestBody @Valid Author author) {
        return authorService.postAuthor(author);
    }

    @GetMapping("/author/by-name-regex")
    public Flux<Author> getAuthorByNameRegex(@RequestParam String name) {
        return authorService.getAuthorByNameRegex(name);
    }

    @GetMapping("/books/by-author")
    public Flux<Book> getBooksByAuthor(@RequestParam String authorName){
        return bookService.getBooksByAuthor(authorName);
    }

}
