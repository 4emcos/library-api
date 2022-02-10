package com.library.api.repository;

import com.library.api.model.AuthorModel;
import com.library.api.model.BookModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AuthorRepository
 */

@Repository
public interface AuthorRepository extends JpaRepository<AuthorModel, Long> {

}