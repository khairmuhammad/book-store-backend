package com.khair.bookstorebackend.repository;


import com.khair.bookstorebackend.entity.BookTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookTransactionRepository extends JpaRepository<com.khair.bookstorebackend.entity.BookTransaction, Long> {
    List<BookTransaction> findAllByStudentId(Long studentId);
}
