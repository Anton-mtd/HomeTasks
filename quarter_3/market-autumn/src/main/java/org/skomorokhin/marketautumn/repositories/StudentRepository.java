package org.skomorokhin.marketautumn.repositories;

import org.skomorokhin.marketautumn.dto.Student;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class StudentRepository {

    private List<Student> students;

    @PostConstruct
    public void init() {
        students = new ArrayList<>(Arrays.asList(
                new Student(1, "Bob"),
                new Student(2,"John"),
                new Student(3, "Dave"),
                new Student(4,"Nicol"),
                new Student(5,"Julia")
        ));
    }

    public Student findById(int id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Студент не найден"));
    }

    public List<Student> getStudents() {
        return students;
    }

}
