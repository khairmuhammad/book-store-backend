package com.khair.bookstorebackend.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BookNotFoundException extends RuntimeException {

    private final HttpStatus httpStatus;

    public BookNotFoundException(String bookTitle) {
        super(String.format("Invalid Book title: %s", bookTitle));
        this.httpStatus = HttpStatus.NOT_FOUND;
    }

    public BookNotFoundException(Long bookId) {
        super(String.format("Invalid BookId: %s", bookId));
        this.httpStatus = HttpStatus.NOT_FOUND;
    }



}
