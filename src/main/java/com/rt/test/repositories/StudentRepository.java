package com.rt.test.repositories;

import com.rt.test.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String >
{

    @Query(value = "select s.* " +
            " from student s " +
            " inner join course_enrolled ec on s.roll_no = ec.student_roll " +
            " inner join course c on ec.course_id = c.course_id" +
            " where c.name = ?1 order by s.name asc", nativeQuery = true)
    List<Student> findByEnrolledCourseNameAsc(String courseName);
}
