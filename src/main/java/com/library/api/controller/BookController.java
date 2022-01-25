package com.library.api.controller;

import java.util.List;

import com.library.api.model.Author;
import com.library.api.model.Book;
import com.library.api.repository.AuthorRepository;
import com.library.api.repository.BookRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

/**
 * BookController
 */

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @GetMapping
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @PostMapping(value = "/{authorId}")
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public Book createBook(@PathVariable("authorId") Long id, @RequestBody Book book) {
        Author author = authorRepository.findById(id).orElse(null);

        if (author == null) {
            throw new IllegalArgumentException("Author not found");
        }

        book.setAuthor(author);

        return bookRepository.save(book);
    }

}