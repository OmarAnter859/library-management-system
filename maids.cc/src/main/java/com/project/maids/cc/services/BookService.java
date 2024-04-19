package com.project.maids.cc.services;

import com.project.maids.cc.entities.Book;
import com.project.maids.cc.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private  final BookRepository bookRepository;
@Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
//    public Page<Book> getbooks(int limet,int offset){
//    return bookRepository.findAll(PageRequest.of(limet,offset));
//    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Integer id, Book updatedBook) {
        updatedBook.setId(id);
        return bookRepository.save(updatedBook);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}
