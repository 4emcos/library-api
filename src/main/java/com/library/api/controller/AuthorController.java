package com.library.api.controller;

import java.util.List;

import com.library.api.dto.request.AuthorRequestDTO;
import com.library.api.dto.response.AuthorResponseDTO;
// import com.library.api.dto.AuthorDTO;
import com.library.api.model.AuthorModel;
import com.library.api.repository.AuthorRepository;

// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<AuthorResponseDTO> listAuthors() {
        return authorRepository.findAll().stream().map(AuthorResponseDTO::new)
                .collect(java.util.stream.Collectors.toList());
    }

    @GetMapping("/{authorId}")
    public AuthorResponseDTO listAuthors(@PathVariable Long authorId) {
        return new AuthorResponseDTO(authorRepository.findById(authorId).orElse(null));

    }

    @PostMapping
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public AuthorRequestDTO createAuthor(@RequestBody AuthorRequestDTO authorDto) {
        authorRepository.save(authorDto.build());
        return authorDto;
    }

}