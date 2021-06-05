package com.rt.test.service;

import com.rt.test.entities.Student;

import java.util.List;

public interface StudentService
{
    Student save(Student student);

    boolean delete(String id);

    List<Student> findStudentByCourse(String courseName);
}
