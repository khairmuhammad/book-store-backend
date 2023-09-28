package com.khair.bookstorebackend.dto.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private String title;
    private String author;
    private String isbn;
    private String genre;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date publishDate;
    private int availableCopies;
    private int totalCopies;
}
