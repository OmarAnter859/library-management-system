package com.project.maids.cc.services;

import com.project.maids.cc.entities.Book;
import com.project.maids.cc.entities.BorrowingBook;
import com.project.maids.cc.entities.Patron;
import com.project.maids.cc.exceptionHandling.InvalidRequestException;
import com.project.maids.cc.exceptionHandling.NotFound;
import com.project.maids.cc.exceptionHandling.ValidationException;
import com.project.maids.cc.repositories.BookRepository;
import com.project.maids.cc.repositories.BorrowingRepository;
import com.project.maids.cc.repositories.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class BorrowingService {
    @Autowired
    private BorrowingRepository browingBookRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PatronRepository patronRepository;


    @Transactional
    public String borrowBook(Integer bookId, Integer patronId) throws InvalidRequestException, NotFound {
        if (bookId == null || patronId == null) {
            throw new InvalidRequestException("Both bookId and patronId must be provided.");
        }

        Book book = bookRepository.findById(bookId).orElse(null);
        Patron patron = patronRepository.findById(patronId).orElse(null);

        if (book == null) {
            throw new NotFound("Book with ID " + bookId + " is not found.");
        }

        if (patron == null) {
            throw new NotFound("Patron with ID " + patronId + " is not found.");
        }

        BorrowingBook borrowingRecord = new BorrowingBook();
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBrowingDate(LocalDate.now());
        browingBookRepository.save(borrowingRecord);

        return "Book borrowed successfully.";
    }

    @Transactional
    public String returnBook(Integer bookId, Integer patronId) {
        BorrowingBook borrowingRecord = browingBookRepository.findByBookIdAndPatronIdAndReturnDateIsNull(bookId, patronId);
        if (borrowingRecord != null) {
            borrowingRecord.setReturnDate(LocalDate.now());
            browingBookRepository.save(borrowingRecord);
            return "Book returned successfully.";
        } else {
            throw new ValidationException("Failed to return book.");
        }
    }
}
