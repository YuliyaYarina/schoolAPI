package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class FacultyService {
    private Map<Long, Faculty> facultyMap = new HashMap<>();
    private long lastId = 0;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++lastId);
        facultyMap.put(lastId, faculty);
        return faculty;
    }

    public Faculty getFaculty(long id) {
        return facultyMap.get(id);
    }

    public Collection<Faculty> getAllFaculty() {
        return facultyMap.values();
    }

    public Faculty editFaculty(Faculty faculty) {
        if (facultyMap.containsKey(faculty.getId())) {
            facultyMap.put(lastId, faculty);
            return faculty;
        }
        return null;
    }

    public Faculty deleteFaculty(long id) {
        return facultyMap.remove(id);
    }

    public Stream<Faculty> getColorFaculty(String color) {
        return getAllFaculty().stream().filter(f->f.getColor().equals(color));
    }

}

