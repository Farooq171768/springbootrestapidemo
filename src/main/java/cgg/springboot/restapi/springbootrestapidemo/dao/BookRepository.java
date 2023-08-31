package cgg.springboot.restapi.springbootrestapidemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cgg.springboot.restapi.springbootrestapidemo.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
    
}
