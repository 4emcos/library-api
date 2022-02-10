package com.library.api.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.library.api.dto.request.AuthorRequestDTO;
import com.library.api.dto.request.BookRequestDTO;
import com.library.api.dto.response.BookResponseDTO;
import com.library.api.model.AuthorModel;
import com.library.api.model.BookModel;
import com.library.api.repository.AuthorRepository;
import com.library.api.repository.BookRepository;

import org.springframework.http.ResponseEntity;
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
    public List<BookResponseDTO> listBooks() {
        return bookRepository.findAll().stream().map(BookResponseDTO::new).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public BookRequestDTO newBook(@RequestBody BookRequestDTO bookDto) {
        AuthorModel author = authorRepository.findById(bookDto.getAuthor()).orElse(null);
        BookModel book = bookDto.build(author);
        bookRepository.save(book);

        return bookDto;
    }

    @PostMapping(value = "/{authorId}")
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public BookModel createBook(@PathVariable("authorId") Long id, @RequestBody BookModel book) {
        AuthorModel author = authorRepository.findById(id).orElse(null);

        if (author == null) {
            throw new IllegalArgumentException("Author not found");
        }

        book.setAuthor(author);

        return bookRepository.save(book);
    }

}