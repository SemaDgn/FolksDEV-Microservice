package com.folksDev.library.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookIdDto {
    private String bookid;
    private String isbn;

    public static BookIdDto convert(String id, String isbn)
    {
        return  new BookIdDto( id, isbn);

    }
}
