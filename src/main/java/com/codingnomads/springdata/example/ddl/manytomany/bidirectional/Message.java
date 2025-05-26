package com.codingnomads.springdata.example.ddl.manytomany.bidirectional;

import com.codingnomads.springdata.example.ddl.manytoone.bidirectional.Teacher;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

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

    @ManyToMany(mappedBy = "messages")
    private Set<Post> posts;
}
