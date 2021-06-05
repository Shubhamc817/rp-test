package com.rt.test.service.impl;

import com.rt.test.entities.Student;
import com.rt.test.repositories.StudentRepository;
import com.rt.test.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
public class StudentServiceImpl implements StudentService
{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student)
    {
        return studentRepository.save(student);
    }

    @Override
    public boolean delete(String id)
    {
        if(nonNull(id))
        {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Student> findStudentByCourse(String courseName)
    {
        return studentRepository.findByEnrolledCourseNameAsc( courseName );
    }
}
