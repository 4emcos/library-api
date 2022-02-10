package com.library.api.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.library.api.model.BookModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BookResponseDTO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookResponseDTO {

    private String title;
    private String publisher;
    private String publicationDate;
    private String language;
    private String category;
    private String description;
    private String status;

    public BookResponseDTO(BookModel book) {
        this.title = book.getTitle();
        this.publisher = book.getPublisher();
        this.publicationDate = book.getPublicationDate();
        this.language = book.getLanguage();
        this.category = book.getCategory();
        this.description = book.getDescription();
        this.status = book.getStatus();
    }

    public List<BookResponseDTO> booksByAuthor(List<BookModel> list) {
        List<BookResponseDTO> resDTO = new ArrayList<>();
        for (BookModel book : list) {
            resDTO.add(new BookResponseDTO(book));
        }

        return resDTO;
    }

}
