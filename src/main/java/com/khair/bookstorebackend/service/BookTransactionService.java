package com.khair.bookstorebackend.service;

import com.khair.bookstorebackend.entity.BookTransaction;
import com.khair.bookstorebackend.repository.BookTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookTransactionService {

    private final BookTransactionRepository bookTransactionRepository;
    public List<BookTransaction> getAllIssuedBooks() {
        return bookTransactionRepository.findAll();
    }

    public List<BookTransaction> getAllIssuedBooksByStudentId(Long studentId) {
        return bookTransactionRepository.findAllByStudentId(studentId);
    }
}
