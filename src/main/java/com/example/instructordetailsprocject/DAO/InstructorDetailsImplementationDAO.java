package com.example.instructordetailsprocject.DAO;

import com.example.instructordetailsprocject.Entity.CoursesEntity;
import com.example.instructordetailsprocject.Entity.InstructorEntity;
import com.example.instructordetailsprocject.Entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Repository
public class InstructorDetailsImplementationDAO implements InstructorDetailsDAO{

    private final EntityManager entityManager;

    @Autowired
    public InstructorDetailsImplementationDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveInstructor(InstructorEntity instructorEntity) {
        //helper method
        entityManager.persist(instructorEntity);
    }

    @Override
    public InstructorEntity fetchInstructor(int id) {
        return entityManager.find(InstructorEntity.class,id);
    }

    @Override
    @Modifying
    @Transactional
    public void addCourseToAnExistingInstructor(int theId, List<CoursesEntity> coursesEntities) {

        final InstructorEntity instructorEntity = entityManager.find(InstructorEntity.class,theId);

        System.out.println(instructorEntity);

        coursesEntities.forEach(instructorEntity::addACourse);

        //entityManager.merge(instructorEntity);

    }

    @Override
    @Modifying
    @Transactional
    public void addAStudentToCourse(final List<Integer> courseIds, final Student student) {

        CoursesEntity courses;
        //finds courses by input course ids then adds student entity to them
        for (Integer courseId : courseIds) {
            courses = entityManager.find(CoursesEntity.class, courseId);
            courses.addAStudent(student);
            entityManager.merge(courses);
        }
    }

}
