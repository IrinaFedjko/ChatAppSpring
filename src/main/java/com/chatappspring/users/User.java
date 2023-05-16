package com.chatappspring.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String profilePictureUrl;
    private String chatColor;
    private Date dateOfBirth;
    private String location;
    private String email;
    private String password;
    private String username;
    private String fullName;
    private String createdAt;
    private String updatedAt;


}
