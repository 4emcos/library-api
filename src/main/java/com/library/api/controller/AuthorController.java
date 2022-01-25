package com.library.api.controller;

import java.util.List;

import com.library.api.model.Author;
import com.library.api.repository.AuthorRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

/**
 * AuthorController
 */

@RestController
@RequestMapping("/api/authors")
@AllArgsConstructor
public class AuthorController {
    private final AuthorRepository authorRepository;

    @GetMapping
    public List<Author> listAuthors() {

        return authorRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }
}