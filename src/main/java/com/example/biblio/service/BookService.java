package com.example.biblio.service;

import com.example.biblio.model.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();
    public void saveOrUpdate(Book b);
    public Book getBookById(Long id);
    public void delete(Long id);
}
