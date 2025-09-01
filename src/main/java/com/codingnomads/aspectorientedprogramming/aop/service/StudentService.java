/* CodingNomads (C)2024 */
package com.codingnomads.aspectorientedprogramming.aop.service;

import com.codingnomads.aspectorientedprogramming.aop.model.Student;
import com.codingnomads.aspectorientedprogramming.aop.repository.StudentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // @TrackMethodExecutionTime
    // @Loggable
    public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }

    // @TrackMethodExecutionTime
    // @Loggable
    public void saveAllStudents(List<Student> students) {
        studentRepository.saveAll(students);
    }

}
