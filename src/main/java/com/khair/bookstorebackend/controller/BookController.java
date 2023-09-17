package com.khair.bookstorebackend.controller;

import com.khair.bookstorebackend.dto.requests.BookRequest;
import com.khair.bookstorebackend.entity.Book;
import com.khair.bookstorebackend.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'STUDENT')")
public class BookController {

    private final BookService bookService;

    @Operation(
            description = "Get endpoint for student",
            summary = "This is a summary for book get endpoint",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }

    )

    @PostMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<Book> createBook(@RequestBody BookRequest request) {
        return ResponseEntity.ok(bookService.createBook(request));
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('admin:read', 'student:read')")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{bookId}")
    @PreAuthorize("hasAnyAuthority('admin:read', 'student:read')")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }

    @PutMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<Book> updateBook(@RequestBody Book request) {
        return ResponseEntity.ok(bookService.updateBook(request));
    }

}
