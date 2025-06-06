/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.ddl.joincolumn;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "examples")
@NoArgsConstructor
@Getter
@Setter
public class Example {

    @Id
    @GeneratedValue
    private Long id;

    // define a one-to-many relationship with a few customizations
    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    // use @JoinColumns to indicate multiple join columns are needed in the examples table
    @JoinColumns({
        // define the first join column. It will be called referenced_id and references the id column in the user table
        @JoinColumn(name = "references_id", referencedColumnName = "id"),
        // define the second join column. It will be called references_name and references the name column in the user
        // table
        @JoinColumn(name = "references_name", referencedColumnName = "name")
    })
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "name", referencedColumnName = "admin_name")
    private Administrator administrator;
}
