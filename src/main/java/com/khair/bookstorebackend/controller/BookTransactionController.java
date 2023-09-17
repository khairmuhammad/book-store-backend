package com.khair.bookstorebackend.controller;

import com.khair.bookstorebackend.entity.BookTransaction;
import com.khair.bookstorebackend.service.BookTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book-transactions")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'STUDENT')")
@CrossOrigin("http://localhost:3000/")
public class BookTransactionController {

    private final BookTransactionService bookTransactionService;

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<BookTransaction>> getAllIssuedBooks() {
        return ResponseEntity.ok(bookTransactionService.getAllIssuedBooks());
    }

    @GetMapping("/{studentId}")
    @PreAuthorize("hasAuthority('student:read')")
    public ResponseEntity<List<BookTransaction>> getAllIssuedBooksByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(bookTransactionService.getAllIssuedBooksByStudentId(studentId));
    }
}
