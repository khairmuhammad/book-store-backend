package com.khair.bookstorebackend.repository;


import com.khair.bookstorebackend.entity.BookRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRequestRepository extends JpaRepository<BookRequest, Long> {

    List<BookRequest> findAllByStudentId(Long studentId);
}
