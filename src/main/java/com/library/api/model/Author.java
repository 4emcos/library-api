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

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author
 */

@Entity
@Table(name = "author")
@NoArgsConstructor
@Data
public class Author {
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

    @OneToMany
    private List<Book> books;

}