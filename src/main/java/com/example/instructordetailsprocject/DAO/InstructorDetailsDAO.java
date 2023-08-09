package com.example.instructordetailsprocject.DAO;

import com.example.instructordetailsprocject.Entity.CoursesEntity;
import com.example.instructordetailsprocject.Entity.InstructorEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InstructorDetailsDAO {

    public static long UUID = 56789L;

    public abstract void saveInstructor(InstructorEntity instructorEntity);

    public abstract InstructorEntity fetchInstructor(int id);

    public abstract void addCourseToAnExistingInstructor(int theId, List<CoursesEntity> coursesEntities);
}
