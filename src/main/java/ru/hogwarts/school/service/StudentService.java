package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;
@Service
public class StudentService {

    private Map<Long, Student> studentMap = new HashMap<>();
    private Long generatedUserId = 1L;


    public Student createUser(Student student) {
        studentMap. put(generatedUserId, student);
        generatedUserId++;
        return student;
    }

    public Student getUserById(Long userId) {
        return studentMap.get(userId);
    }

    public Student updateUser(Long userId, Student student) {
        studentMap.put(generatedUserId, student);
        return student;
    }

    public Student deleteUser(Long userId) {
        return studentMap.remove(userId);
    }
}
