package cgg.springboot.restapi.springbootrestapidemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cgg.springboot.restapi.springbootrestapidemo.entities.Book;
import cgg.springboot.restapi.springbootrestapidemo.services.BooksService;

@RestController
public class BooksController {

    @Autowired
    private BooksService booksService;
    
    @GetMapping("/books")
    public List<Book> getBooks(){
    //     Book book=new Book();
    //     book.setBookId(12);
    //    book.setTitle("Java complete reference");
    //     book.setAuthor("XYZ");
    //     return book;
            return this.booksService.getBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") int id){
            return this.booksService.getBookById(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        Book book2=this.booksService.addBook(book);
        return book2;
    }
    @PutMapping("/books/{id}")
    public List<Book> updateBook(@RequestBody Book book, @PathVariable("id") int id){
        return this.booksService.updateBook(book,id);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int id){
            this.booksService.deleteBook(id);
    }

    
}
