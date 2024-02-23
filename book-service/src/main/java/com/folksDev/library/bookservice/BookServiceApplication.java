package com.folksDev.library.bookservice;

import com.folksDev.library.bookservice.model.Book;
import com.folksDev.library.bookservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BookServiceApplication  implements CommandLineRunner {

	private  final BookRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	public BookServiceApplication(BookRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("","Dünyanın Gözü",2000,"Robert Jordan","İthaki Yayınevi","123" );
		Book book2 = new Book("","Yüzüklerin Efendisi",1960,"J.R.R Tolkien","Metis Yayınevi","456");
		Book book3 = new Book("","Harry Potter ve Felsefe Taşı",1997,"J.K. Rowling","YK Yayınevi","789");
		List<Book> bookList= repository.saveAll(Arrays.asList(book1,book2,book3));
		System.out.println(bookList);


	}
}
