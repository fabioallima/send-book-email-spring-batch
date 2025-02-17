package com.example.send_book_email_spring_batch.entities.pk;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class UserBookLoanId implements java.io.Serializable {
    private Integer user;
    private Integer book;
}
