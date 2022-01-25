package com.library.api.repository;

import com.library.api.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BookRepository
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}