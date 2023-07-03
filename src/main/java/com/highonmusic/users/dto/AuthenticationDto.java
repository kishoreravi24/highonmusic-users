package com.highonmusic.users.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class AuthenticationDto {
    @Id
    private String username;
    private String password;
}
