package com.codingnomads.springdata.example.ddl.manytomany.unidirectional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, updatable = false)
    private String message;

    @Column(nullable = false)
    private String sender;
}
