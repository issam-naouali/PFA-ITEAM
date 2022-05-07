package com.example.biblio.controller;

import com.example.biblio.model.Book;
import com.example.biblio.service.BookService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookservice;


    @RequestMapping (value = "/book/list", method = RequestMethod.GET)
    public ModelAndView getAllBooks(){
        ModelAndView model = new ModelAndView();
        List<Book> listBooks = bookservice.getAllBooks();
        model.addObject("Books", listBooks);
        model.setViewName("List_Books");
        return model;
    }


    @RequestMapping (value = "/book/add", method = RequestMethod.GET)
    public ModelAndView addBook(){
        ModelAndView model = new ModelAndView();
        Book book = new Book();
        model.addObject("book",book);
        model.setViewName("Add_Books");
        return model;
    }

    @RequestMapping (value = "/book/update/{id}", method = RequestMethod.GET)
    public ModelAndView updateBook(@PathVariable("id") Long id){
        ModelAndView model = new ModelAndView();
        Book book = bookservice.getBookById(id);
        model.addObject("book",book);
        model.setViewName("Update_Books");
        return model;
    }

    @RequestMapping (value = "/book/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteBook(@PathVariable("id") Long id) {
        bookservice.delete(id);
        return (new ModelAndView("redirect:/book/list"));
    }

    @RequestMapping (value = "/book/save", method = RequestMethod.POST)
    public ModelAndView saveBook(@ModelAttribute("book") Book book){
        bookservice.saveOrUpdate(book);
        return (new ModelAndView("redirect:/book/list"));
    }

}
