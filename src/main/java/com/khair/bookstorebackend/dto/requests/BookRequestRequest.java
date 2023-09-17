package com.khair.bookstorebackend.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestRequest {
    private Long studentId;
    private Long bookId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date requestDate;
    private String status;
}
