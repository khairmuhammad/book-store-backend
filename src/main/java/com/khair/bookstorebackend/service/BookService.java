package com.khair.bookstorebackend.service;

import com.khair.bookstorebackend.dto.requests.BookRequest;
import com.khair.bookstorebackend.entity.Book;
import com.khair.bookstorebackend.exception.BookNotFoundException;
import com.khair.bookstorebackend.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    public Book createBook(BookRequest request) {
        var book = Book
                .builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .genre(request.getGenre())
                .publishDate(request.getPublishDate())
                .availableCopies(request.getAvailableCopies())
                .totalCopies(request.getTotalCopies())
                .build();
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book updateBook(Book request) {
        Book book = bookRepository.findByBookId(request.getBookId())
                .orElseThrow(() -> new BookNotFoundException(request.getTitle()));
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getIsbn());
        book.setGenre(request.getGenre());
        book.setPublishDate(request.getPublishDate());
        book.setAvailableCopies(request.getAvailableCopies());
        book.setTotalCopies(request.getTotalCopies());

        return bookRepository.save(book);
    }

    public Book getBookById(Long bookId) {
        return bookRepository.findByBookId(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
    }
}
