package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Stream;

@Service
public class StudentService {

    private final HashMap<Long, Student> studentMap = new HashMap<>();
    private long studentId = 0;

    public Student createStudent(Student student) {
        student.setId(++studentId);
        studentMap.put(studentId, student);
        return student;
    }

    public Student findStudentById(long Id) {
        return studentMap.get(Id);
    }
    public Collection<Student> getAllStudent() {
        return studentMap.values();
    }

    public Student editStudent(Student student) {
        if (studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student deleteStudent(long Id) {
        return studentMap.remove(Id);
    }

    public Stream<Student> getAgeStusent(int age) {
        return getAllStudent().stream().filter(s->s.getAge() == age);
    }
}
