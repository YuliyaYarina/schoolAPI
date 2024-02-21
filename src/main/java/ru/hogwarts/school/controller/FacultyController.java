package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.stream.Stream;

@RequestMapping("/faculty")
@RestController
public class FacultyController {
    private FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("{id}")
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping("{id}")
    public ResponseEntity getFaculty(@PathVariable long id) {
        Faculty faculty = facultyService.getFaculty(id);
        if(faculty == null) {
            return ResponseEntity.notFound() .build();
        }
        return ResponseEntity.ok(faculty);
    }
    @GetMapping
    private ResponseEntity<Collection<Faculty>> getAllFaculty () {
        return ResponseEntity.ok(facultyService.getAllFaculty());
    }
    @PutMapping()
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = facultyService.editFaculty(faculty);
        if(updatedFaculty == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(updatedFaculty);
    }

    @DeleteMapping("{id}")
    public Faculty deleteBook(@PathVariable long id){
        return facultyService.deleteFaculty(id);
    }

    @GetMapping("/color")
    public Stream<Faculty> filterColor(@RequestParam String color){
        return facultyService.getColorFaculty(color);
    }
}
