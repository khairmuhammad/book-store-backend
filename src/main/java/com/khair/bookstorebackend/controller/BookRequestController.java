package com.khair.bookstorebackend.controller;

import com.khair.bookstorebackend.dto.requests.BookRequestRequest;
import com.khair.bookstorebackend.entity.BookRequest;
import com.khair.bookstorebackend.service.BookRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book-request")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000/")
@PreAuthorize("hasAnyRole('ADMIN', 'STUDENT')")
public class BookRequestController {

    private final BookRequestService bookRequestService;

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<BookRequest>> getAllRequestedBooks() {
        return ResponseEntity.ok(bookRequestService.getAllRequestedBooks());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:create')")
    public ResponseEntity<BookRequest> requestBook(@RequestBody BookRequestRequest request) {
        return ResponseEntity.ok(bookRequestService.requestBook(request));
    }

    @GetMapping("/{studentId}")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<BookRequest>> getRequestedBooksByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(bookRequestService.getRequestedBooksByStudentId(studentId));
    }
}
