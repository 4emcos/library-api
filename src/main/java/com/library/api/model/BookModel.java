package com.library.api.model;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

/**
 * Book
 */

@Entity
@Data
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @JsonBackReference
    @ManyToOne(fetch = javax.persistence.FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private AuthorModel author;

    private String publisher;

    private String publicationDate;

    private String language;

    private String category;

    private String description;

    private String status;

    private String image;

    private String createdDate;

    private String updatedDate;

}