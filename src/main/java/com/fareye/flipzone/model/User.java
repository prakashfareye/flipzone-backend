package com.fareye.flipzone.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users",
       uniqueConstraints = @UniqueConstraint(
              name="unique_user_email_id",
               columnNames ="user_email_id"
       )
)
public class User {

    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "user_sequence"
    )
    @Column(name="user_id")
    private Long userId;
    @NotBlank(message = "Name is mandatory")

    @Column(name="username")
    private String userName;

    @Email
    @NotBlank(message = "Email is mandatory")
    @Column(name="user_email_id")
    private String userEmailId;
    @Column
    private String password;

}
