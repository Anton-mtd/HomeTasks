package org.skomorokhin.marketautumn.services;

import lombok.RequiredArgsConstructor;
import org.skomorokhin.marketautumn.dto.Student;
import org.skomorokhin.marketautumn.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getStudents();
    }

}
