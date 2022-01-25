package com.library.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * Book
 */

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    private Author author;

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