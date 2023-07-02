package com.highonmusic.users.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "test")
public class TestDto {
    @Id
    private int id;
    private String name;
}
