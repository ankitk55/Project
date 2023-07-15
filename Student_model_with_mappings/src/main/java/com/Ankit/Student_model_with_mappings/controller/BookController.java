package com.Ankit.Student_model_with_mappings.controller;

import com.Ankit.Student_model_with_mappings.model.Book;
import com.Ankit.Student_model_with_mappings.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("book")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }
    @GetMapping("books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("book/{bookId}")
    public Book getBookById(@PathVariable Long bookId){
        return bookService.getBookById(bookId);
    }
    @PutMapping("book/{bookId}/{price}")
    public String updatePrice(@PathVariable Long bookId,@PathVariable Integer price){
        return bookService.updatePrice(bookId,price);
    }
    @DeleteMapping("book/{bookId}")
    public void deleteBook(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
    }
}
