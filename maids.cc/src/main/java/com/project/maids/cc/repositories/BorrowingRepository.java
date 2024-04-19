package com.project.maids.cc.repositories;

import com.project.maids.cc.entities.BorrowingBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRepository extends JpaRepository<BorrowingBook, Integer> {
    BorrowingBook findByBookIdAndPatronIdAndReturnDateIsNull(Integer bookId, Integer patronId);
    boolean existsBorrowingBookById(Integer bookId);
    boolean existsBorrowingPatronById(Integer patronId);
}