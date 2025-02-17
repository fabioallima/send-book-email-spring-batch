package com.example.send_book_email_spring_batch.entities;

import com.example.send_book_email_spring_batch.entities.pk.UserBookLoanId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tb_user_book_loan")
@IdClass(UserBookLoanId.class)
public class UserBookLoan {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(nullable = false)
    private LocalDate loanDate;
}
