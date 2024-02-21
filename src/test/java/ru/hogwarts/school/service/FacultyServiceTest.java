package ru.hogwarts.school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FacultyServiceTest {

    private final FacultyService facultyService= new FacultyService();
    @Test
    void createFaculty() {
        // given
        Faculty faculty = new Faculty(1L, "b", "red");
        // wheh
        Faculty addedStudent = facultyService.createFaculty(faculty);
        // then
        Assertions.assertEquals(faculty, addedStudent);
    }

    @Test
    void getFaculty() {
        // given
        Faculty s1 = new Faculty(1L, "a", "red");
        Faculty s2 = new Faculty(2L, "b", "red");
        Faculty s3 = new Faculty(3L, "c", "yeloo");

        facultyService.createFaculty(s1);
        facultyService.createFaculty(s2);
        facultyService.createFaculty(s3);


        // wheh
        Faculty actualQ = facultyService.getFaculty(2);
        // then
        Assertions.assertEquals(s2, actualQ);
    }

    @Test
    void getAllFaculty() {
        // given
        Faculty s1 = new Faculty(1L, "a", "red");
        Faculty s2 = new Faculty(2L, "b", "red");
        Faculty s3 = new Faculty(3L, "c", "yeloo");

        facultyService.createFaculty(s1);
        facultyService.createFaculty(s2);
        facultyService.createFaculty(s3);
        // wheh
        Collection<Faculty> actualQ = facultyService.getAllFaculty();
        // then
        Assertions.assertIterableEquals(List.of(s1, s2, s3), actualQ);
    }

    @Test
    void editFaculty() {
        // given
        Faculty s1 = new Faculty(1L, "a", "red");
        Faculty s2 = new Faculty(2L, "b", "red");
        Faculty s3 = new Faculty(3L, "c", "yeloo");

        facultyService.createFaculty(s1);
        facultyService.createFaculty(s2);
        facultyService.createFaculty(s3);
        // wheh
        Faculty actualQ = facultyService.editFaculty(s1);
        // then
        Assertions.assertEquals(s1, actualQ);
    }

    @Test
    void deleteFaculty() {
        // given
        Faculty s1 = new Faculty(1L, "a", "red");
        Faculty s2 = new Faculty(2L, "b", "red");
        Faculty s3 = new Faculty(3L, "c", "yeloo");

        facultyService.createFaculty(s1);
        facultyService.createFaculty(s2);
        facultyService.createFaculty(s3);
        // wheh
        Faculty addedFaculty = facultyService.deleteFaculty(1);
        // then
        Assertions.assertEquals(s1, addedFaculty);
    }

    @Test
    void getColorFaculty() {
        // given
        Faculty s1 = new Faculty(1L, "a", "red");
        Faculty s2 = new Faculty(2L, "b", "red");
        Faculty s3 = new Faculty(3L, "c", "yeloo");

        facultyService.createFaculty(s1);
        facultyService.createFaculty(s2);
        facultyService.createFaculty(s3);
        // wheh
        Stream<Faculty> addedFaculty = facultyService.getColorFaculty("red");
        // then
        Assertions.assertEquals(s1, addedFaculty);

    }
}