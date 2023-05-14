package com.ner3k.myapp.services;

import com.ner3k.myapp.models.Book;
import com.ner3k.myapp.repositories.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public List<Book> getAllBooks(){
        return  bookRepository.findAll();
    }
    public Book createBook(Book book){
        return bookRepository.save(book);
    }
    public Book findBookById(Long id){
        if(bookRepository.findById(id).isPresent())
            return bookRepository.findById(id).get();
        else return null;
    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

}
