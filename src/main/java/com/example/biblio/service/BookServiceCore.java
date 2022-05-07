package com.example.biblio.service;

import com.example.biblio.model.Book;
import com.example.biblio.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service  // to define as service
@Transactional

public class BookServiceCore implements BookService{

    @Autowired
    BookRepository bookagent;

    @Override
    public List<Book> getAllBooks() {
        return bookagent.findAll();
    }

    @Override
    public void saveOrUpdate(Book b) {
        bookagent.save(b);
    }

    @Override
    public Book getBookById(Long id) {
        return bookagent.findById(id).get();
//        return bookagent.findBookById(id);
    }

    @Override
    public void delete(Long id) {
        bookagent.deleteById(id);
    }
}
