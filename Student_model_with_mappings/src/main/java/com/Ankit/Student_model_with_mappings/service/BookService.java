package com.Ankit.Student_model_with_mappings.service;

import com.Ankit.Student_model_with_mappings.model.Book;
import com.Ankit.Student_model_with_mappings.repository.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    IBookRepo bookRepo;


    public void addBook(Book book) {
        bookRepo.save(book);
    }

    public List<Book> getAllBooks() {
        return  bookRepo.findAll();
    }

    public Book getBookById(Long bookId) {
        return bookRepo.findById(bookId).orElse(null);
    }

    public String updatePrice(Long bookId, Integer price) {
        Book book =bookRepo.findById(bookId).orElse(null);
        if(book ==null){
            return "invalid Book id ..";
        }
        book.setPrice(price);
        bookRepo.save(book);
        return "book price changed for this id  : "+bookId;
    }

    public void deleteBook(Long bookId) {
        bookRepo.deleteById(bookId);
    }
}
