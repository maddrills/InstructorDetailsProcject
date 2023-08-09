package com.example.instructordetailsprocject.DAO;

import com.example.instructordetailsprocject.Entity.CoursesEntity;
import com.example.instructordetailsprocject.Entity.InstructorEntity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        entityManager.merge(instructorEntity);

    }

}
