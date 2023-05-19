package com.crud.springboot.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Task {
    @Id //indica que es el identificador
    private String id;
    private String name;
    private boolean completed;
}
