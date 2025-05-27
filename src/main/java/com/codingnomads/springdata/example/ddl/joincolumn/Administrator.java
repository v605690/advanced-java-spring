package com.codingnomads.springdata.example.ddl.joincolumn;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "administrators")
@NoArgsConstructor
@Getter
@Setter
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "admin_name", unique = true, nullable = false)
    private String adminName;

    private String role;

    @OneToOne
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    private Guest guest;

}