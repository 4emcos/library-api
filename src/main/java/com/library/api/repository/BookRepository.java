package com.library.api.repository;

import com.library.api.model.BookModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BookRepository
 */

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {

}