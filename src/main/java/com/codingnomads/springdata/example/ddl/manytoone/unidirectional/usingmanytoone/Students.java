package com.codingnomads.springdata.example.ddl.manytoone.unidirectional.usingmanytoone;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Students {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, updatable = false)
    private String name;

    @Column(nullable = false)
    private String course;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Post post;
}
