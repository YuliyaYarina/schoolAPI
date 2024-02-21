package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;
@Service
public class FacultyService {
    private Map<Long, Student> facultyMap = new HashMap<>();
    private Long generatedFacultyId = 1L;

    public Student createFaculty(Student student) {
        facultyMap.put(generatedFacultyId, student);
        generatedFacultyId++;
        return student;
    }

    public Student getFacultyById(Long userId) {
        return facultyMap.get(userId);
    }

    public Student updateFaculty(Long facultyId, Student student) {
        facultyMap.put(generatedFacultyId, student);
        return student;
    }

    public Student deleteFaculty(Long facultyId) {
        return facultyMap.remove(facultyId);
    }
}

