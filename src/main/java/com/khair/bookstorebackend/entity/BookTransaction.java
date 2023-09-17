package com.khair.bookstorebackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BookTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private Long studentId;
    private Long bookId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date issueDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;
    private String status;
}
