/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.lifecyclecallback;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PrintEntity {

    @Id
    @GeneratedValue
    private Long id;

    // write your methods here
    @PostLoad
    public void idStatus() {
        System.out.println("Printing entity with id: " + id);
    }

    @PrePersist
    @PreUpdate
    private void checkForIllegalState() {
        System.out.println("PrePersist and PreUpdate");
    }
}
