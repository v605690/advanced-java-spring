/* CodingNomads (C)2024 */
package com.codingnomads.aspectorientedprogramming.aop.repository;

import com.codingnomads.aspectorientedprogramming.aop.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    String findByName(String name);

    List<Student> findAllByEmail(String email);
}
