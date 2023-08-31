package cgg.springboot.restapi.springbootrestapidemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cgg.springboot.restapi.springbootrestapidemo.dao.BookRepository;
import cgg.springboot.restapi.springbootrestapidemo.entities.Book;

@Component
public class BooksService {

    @Autowired
    private BookRepository bookRepo;
    // private static List<Book> books = new ArrayList<>();

    // static{
    //     books.add(new Book(5,"Java Head First","ABC"));
    //     books.add(new Book(12,"Java Cmplete First","MNO"));
    //     books.add(new Book(1212,"Java Tail","JKL"));
    // }

    //Get all books
    public List<Book> getBooks(){
        List<Book> list=bookRepo.findAll();
        return list;
    }
    //Get single book
    public Book getBookById(int id){
        Book book=null;
        try{
                book= bookRepo.findById(id).get();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
       return book;
    }
    //Adding a book
    public Book addBook(Book book){
        Book book2=bookRepo.save(book);
        return book2;
    }
    //Updating a book
    public void updateBook(Book book, int id){
        // books= books.stream().map(b->{
        //     if(b.getBookId()==id){
        //         b.setAuthor(book.getAuthor());
        //         b.setTitle(book.getTitle());
        //     }
        //     return b;
        // }).collect(Collectors.toList());
        Book b=bookRepo.findById(id).get();
        b.setAuthor(book.getAuthor());
        b.setTitle(book.getTitle());
        Book book2=bookRepo.save(b);
        
    }
    //Deleting a book
    public void deleteBook(int id){
       //books= books.stream().filter(b->b.getBookId()!=id).collect(Collectors.toList());
       bookRepo.deleteById(id);
    }
}
