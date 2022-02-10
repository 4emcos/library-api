package com.library.api.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

/**
 * Author
 */

@Entity
@Table(name = "author")
@Data
public class AuthorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String phone;

    private String address;

    private String city;

    private String state;

    private String zip;

    private String country;

    // @ManyToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "author_id")
    // private Author parent;

    @JsonManagedReference
    @OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "author", fetch = javax.persistence.FetchType.LAZY)
    private List<BookModel> books;

}