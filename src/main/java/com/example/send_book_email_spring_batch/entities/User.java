package com.example.send_book_email_spring_batch.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false, length = 60, unique = true)
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<UserBookLoan> loans;
}
