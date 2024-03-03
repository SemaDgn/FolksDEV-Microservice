package com.library.libraryservice.controller;

import com.library.libraryservice.dto.AddBookRequest;
import com.library.libraryservice.dto.LibraryDto;
import com.library.libraryservice.service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {

    private  final LibraryService libraryService;
    private final Environment environment;

    Logger logger = LoggerFactory.getLogger(LibraryController.class);
    public LibraryController(LibraryService libraryService, Environment environment) {
        this.libraryService = libraryService;
        this.environment=environment;
    }

    @GetMapping("{id}")
    public ResponseEntity<LibraryDto> getLibraryById(@PathVariable String id)
    {
        return  ResponseEntity.ok(libraryService.getAllBooksInLibraryById(id));

    }
    @PostMapping
    public  ResponseEntity<LibraryDto>  createLibrary()
    {
        logger.info("Library created on port number: "+ environment.getProperty("localhost.server.port"));

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
    @GetMapping
    public  ResponseEntity<List<String>> getAllLibrary()
    {
        return  ResponseEntity.ok(libraryService.getAllLibraries());


    }



}
