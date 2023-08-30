package cgg.springboot.restapi.springbootrestapidemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import cgg.springboot.restapi.springbootrestapidemo.entities.Book;

@Component
public class BooksService {
    private static List<Book> books = new ArrayList<>();

    static{
        books.add(new Book(5,"Java Head First","ABC"));
        books.add(new Book(12,"Java Cmplete First","MNO"));
        books.add(new Book(1212,"Java Tail","JKL"));
    }

    //Get all books
    public List<Book> getBooks(){
        return books;
    }
    //Get single book
    public Book getBookById(int id){
       Book book= books.stream().filter(b->b.getBookId()==id).findFirst().get();
       return book;
    }
    //Adding a book
    public Book addBook(Book book){
        books.add(book);
        return book;
    }
    //Updating a book
    public List<Book> updateBook(Book book, int id){
        books= books.stream().map(b->{
            if(b.getBookId()==id){
                b.setAuthor(book.getAuthor());
                b.setTitle(book.getTitle());
            }
            return b;
        }).collect(Collectors.toList());
        return books;
    }
    //Deleting a book
    public void deleteBook(int id){
       books= books.stream().filter(b->b.getBookId()!=id).collect(Collectors.toList());
    }
}
