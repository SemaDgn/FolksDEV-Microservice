package com.folksDev.library.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private String id ;
    private String title;
    private Integer bookYear;
    private String author;
    private String pressName;
    private String isbn;

    public static BookDto convert(String id, String title, Integer bookYear,String author, String pressName, String isbn)
    {
        return  new BookDto( id,  title,  bookYear,author,  pressName,  isbn);

    }


}
