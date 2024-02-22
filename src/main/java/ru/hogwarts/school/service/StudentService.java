package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Stream;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudentById(long id) {
        return studentRepository.findById(id).get();
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }
    public void deleteStudent(long id) {
         studentRepository.deleteById(id);
    }
    public Collection<Student> getAllStudent() {
        return studentRepository.findAll();
    }

//    public Collection<Student> getAgeStusent(int age) {
//        return studentRepository.stream().filter(s->s.getAge() == age);
//    }
}
