package com.library.libraryservice.service;

import com.library.libraryservice.client.BookServiceClient;
import com.library.libraryservice.dto.AddBookRequest;
import com.library.libraryservice.dto.LibraryDto;
import com.library.libraryservice.exception.LibraryNotFoundException;
import com.library.libraryservice.model.Library;
import com.library.libraryservice.repository.LibraryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class LibraryService {
    private  final LibraryRepository libraryRepository;
    private  final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
        this.libraryRepository = libraryRepository;
        this.bookServiceClient=bookServiceClient;
    }

    public LibraryDto getAllBooksInLibraryById(String id)
    {
        Library library= libraryRepository.findById(id)
                .orElseThrow(()-> new LibraryNotFoundException("Library could not found by Id :"+id));
        // bu noktada null patlayıp patlayamayacagını bılemıyorum dıkkat et.
        LibraryDto libraryDto= new LibraryDto(library.getId(),library.getUserBook().stream()
                .map(book->bookServiceClient.getBookById(book).getBody())
                .collect(Collectors.toList()));
        return libraryDto;
    }

    public LibraryDto createLibrary()
    {
        Library newLibrary=libraryRepository.save(new Library());
        return new LibraryDto(newLibrary.getId(),null);

    }
    public  void addBookToLibrary(AddBookRequest request)
    {
        String bookId=bookServiceClient.getBookByIsbn(request.getIsbn()).getBody().getBookid();
        Library library= libraryRepository.findById(request.getId())
                .orElseThrow(()-> new LibraryNotFoundException("Library could not found by Id :"+request.getId()));

        library.getUserBook().add(bookId);
        libraryRepository.save(library);
    }

    public List<String> getAllLibraries() {
        return libraryRepository.findAll()
                .stream()
                .map(l->l.getId())
                .collect(Collectors.toList());
    }
}
