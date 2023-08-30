package cgg.springboot.restapi.springbootrestapidemo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private int bookId;
    private String title;
    private String author;

   
}
