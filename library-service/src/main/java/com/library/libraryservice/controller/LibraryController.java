package com.library.libraryservice.controller;

import com.library.libraryservice.dto.AddBookRequest;
import com.library.libraryservice.dto.LibraryDto;
import com.library.libraryservice.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {
    private  final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("{id}")
    public ResponseEntity<LibraryDto> getLibraryById(@PathVariable String id)
    {
        return  ResponseEntity.ok(libraryService.getAllBooksInLibraryById(id));

    }
    @PostMapping
    public  ResponseEntity<LibraryDto>  createLibrary()
    {
        return  ResponseEntity.ok(libraryService.createLibrary());
    }
    //ben bu kütüpheneye bir kitap eklemem lazım. bunun için book service ile haberleşmem lazım.
    // bu noktada libray ve book servisin  euraka servera register olması gerekir. euraka üzerinden haberleşmem gerekiyor.

    @PutMapping
     public ResponseEntity<Void> addBookToLibrary(@RequestBody AddBookRequest request)
    {
        libraryService.addBookToLibrary(request);
        return ResponseEntity.ok().build();

    }

}
