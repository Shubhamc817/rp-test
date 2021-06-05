package com.rt.test.controller;

import com.rt.test.entities.Student;
import com.rt.test.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController
{
    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    //ADD DTO for Student

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student)
    {
        return ResponseEntity.ok(studentService.save( student ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") String id)
    {
        return ResponseEntity.ok(studentService.delete(id));
    }

    @GetMapping
    public ResponseEntity<List<Student>> findByCourseEnrolledIn(@RequestParam(name = "courseName") String courseName)
    {
        return ResponseEntity.ok(studentService.findStudentByCourse(courseName));
    }
}
