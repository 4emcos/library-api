package com.library.api.dto.response;

import java.util.List;

import com.library.api.dto.response.BookResponseDTO;
import com.library.api.model.AuthorModel;
import com.library.api.model.BookModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AuthorResponseDTO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponseDTO {

    private String name;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private List<BookResponseDTO> books;

    public AuthorResponseDTO(AuthorModel author) {
        BookResponseDTO resDTo = new BookResponseDTO();
        this.address = author.getAddress();
        this.city = author.getCity();
        this.country = author.getCountry();
        this.name = author.getName();
        this.phone = author.getPhone();
        this.state = author.getState();
        this.zip = author.getZip();
        this.books = resDTo.booksByAuthor(author.getBooks());
    }

}