package com.khair.bookstorebackend.service;

import com.khair.bookstorebackend.dto.requests.BookRequestRequest;
import com.khair.bookstorebackend.entity.BookRequest;
import com.khair.bookstorebackend.repository.BookRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookRequestService {

    private final BookRequestRepository bookRequestRepository;
    public List<BookRequest> getAllRequestedBooks() {
        return bookRequestRepository.findAll();
    }

    public BookRequest requestBook(BookRequestRequest request) {
        var bookRequest = BookRequest
                .builder()
                .bookId(request.getBookId())
                .studentId(request.getStudentId())
                .requestDate(request.getRequestDate())
                .status(request.getStatus())
                .build();
        return bookRequestRepository.save(bookRequest);
    }

    public List<BookRequest> getRequestedBooksByStudentId(Long studentId) {
        return bookRequestRepository.findAllByStudentId(studentId);
    }
}
