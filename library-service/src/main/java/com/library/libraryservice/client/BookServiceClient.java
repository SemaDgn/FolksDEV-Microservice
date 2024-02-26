package com.library.libraryservice.client;

import com.library.libraryservice.dto.*;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-service",path = "v1/book")
public interface BookServiceClient {

    Logger logger= LoggerFactory.getLogger(BookServiceClient.class);

    /* case 1 için kullanılan isbn id sorgulmaası
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable String isbn) ;
        @GetMapping("/book/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable String id) ;

    */

    //Burada yazılan fallback methosuyla hata olustugunda baska bır senaryayo gecıyorum.
    @GetMapping("/isbn/{isbn}")
    @CircuitBreaker(name="getBookByIsbnCircuitBreaker", fallbackMethod = "getBookFallBack")
    public ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable String isbn) ;

    // default olarak yazılmış fallback metorları her zaman fallback metodu parametresi ve exception parametresi alır.
    // fallbackmethos alanında tanımlanan isimle aynı olmalıdır.
    default  ResponseEntity<BookIdDto> getBookFallBack( String isbn, Exception exception)
    {
        logger.info("Book not found by isbn:"+ isbn +", returning default BookDto object");
        return  ResponseEntity.ok(BookIdDto.convert("default-book", "default-isbn"));
    }

    @GetMapping("/book/{id}")
    @CircuitBreaker(name="getBookByIdCircuitBreaker", fallbackMethod = "getBookByIdFallBack")
    public ResponseEntity<BookDto> getBookById(@PathVariable String id) ;

    default  ResponseEntity<BookDto> getBookIdFallBack( String bookId, Exception exception)
    {
        logger.info("Book not found by id:"+ bookId +", returning default BookDto object");
        return  ResponseEntity.ok( new BookDto("default-book","",0,"", "default-isbn"));
    }


}
