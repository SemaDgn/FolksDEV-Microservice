package com.library.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class BookDto {
        private String bookid ;
        private String title;
        private Integer bookYear;
        private String author;
        private String pressName;
        public static BookDto convert(String id, String title, Integer bookYear,String author, String pressName)
        {
            return  new BookDto( id,  title,  bookYear,author,  pressName);

        }
}
