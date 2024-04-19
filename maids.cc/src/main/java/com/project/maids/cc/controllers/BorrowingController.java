package com.project.maids.cc.controllers;

import com.project.maids.cc.exceptionHandling.InvalidRequestException;
import com.project.maids.cc.exceptionHandling.NotFound;
import com.project.maids.cc.services.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrow")
public class BorrowingController {
    @Autowired
    private BorrowingService borrowingService;

    @PostMapping("/{bookId}/patron/{patronId}")
    public ResponseEntity<String> borrowBook(@PathVariable Integer bookId, @PathVariable Integer patronId) {
        try {
            String message = borrowingService.borrowBook(bookId, patronId);
            return ResponseEntity.ok(message);
        } catch (InvalidRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<String> returnBook(@PathVariable Integer bookId, @PathVariable Integer patronId) {
        try {
            String message = borrowingService.returnBook(bookId, patronId);
            return ResponseEntity.ok(message);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
