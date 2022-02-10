package com.library.api.dto.request;

import com.library.api.model.AuthorModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AuthorDTO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequestDTO {

    private String name;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;

    public AuthorModel build() {
        AuthorModel author = new AuthorModel();

        author.setName(this.name);
        author.setPhone(this.phone);
        author.setAddress(this.address);
        author.setCity(this.city);
        author.setState(this.state);
        author.setZip(this.zip);
        author.setCountry(this.country);

        return author;
    }
}