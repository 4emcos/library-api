package com.library.api.dto.request;

import java.util.List;

import com.library.api.model.AuthorModel;
import com.library.api.model.BookModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BookDTO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDTO {

    private String title;
    private String publisher;
    private String publicationDate;
    private String language;
    private String category;
    private String description;
    private String status;
    private String image;
    private String createdDate;
    private String updatedDate;
    private Long author;

    public BookModel build(AuthorModel author) {
        BookModel book = new BookModel();
        book.setTitle(this.title);
        book.setPublisher(this.publisher);
        book.setPublicationDate(this.publicationDate);
        book.setLanguage(this.language);
        book.setCategory(this.category);
        book.setDescription(this.description);
        book.setAuthor(author);

        return book;
    }
}