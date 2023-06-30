package com.highonmusic.users.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "test")
public class Testmodel {
    @Id
    private int id;
    private String name;
}
