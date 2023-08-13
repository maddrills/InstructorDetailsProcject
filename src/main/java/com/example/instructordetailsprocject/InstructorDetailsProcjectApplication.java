package com.example.instructordetailsprocject;

import com.example.instructordetailsprocject.DAO.InstructorDetailsDAO;
import com.example.instructordetailsprocject.Entity.AddressEntity;
import com.example.instructordetailsprocject.Entity.CoursesEntity;
import com.example.instructordetailsprocject.Entity.InstructorEntity;
import com.example.instructordetailsprocject.Entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InstructorDetailsProcjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstructorDetailsProcjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(@Autowired  InstructorDetailsDAO instructorDetailsDAO){

        return (instructions) -> {

            //saveInstructor(instructorDetailsDAO);

            //fetchInstructor(instructorDetailsDAO);

            //addInstructorAndAddress(instructorDetailsDAO);

            addCourseToInstructor(instructorDetailsDAO);

            //addAStudentToARangeOfCourses(instructorDetailsDAO);

        };

    }

    private void addAStudentToARangeOfCourses(InstructorDetailsDAO instructorDetailsDAO) {

        instructorDetailsDAO.addAStudentToCourse(
                List.of(1,2),
                new Student("Aman",22)
        );

    }

    private void addCourseToInstructor(InstructorDetailsDAO instructorDetailsDAO) {

        instructorDetailsDAO.addCourseToAnExistingInstructor(1, List.of(
                new CoursesEntity("JAVA"),
                new CoursesEntity("PYTHON")
                ));

    }

    private void addInstructorAndAddress(InstructorDetailsDAO instructorDetailsDAO) {

        InstructorEntity instructorEntity = new InstructorEntity(
                "Mathew",
                "Francis",
                25
        );

        AddressEntity addressEntity = new AddressEntity(
                "E - 42/9 phase 2 cv Ramanagar ",
                560093
        );

        instructorEntity.addAnAddress(addressEntity);

        instructorDetailsDAO.saveInstructor(instructorEntity);

    }

    private void fetchInstructor(InstructorDetailsDAO instructorDetailsDAO) {

        System.out.println(instructorDetailsDAO.fetchInstructor(1));
    }


    public void saveInstructor(InstructorDetailsDAO instructorDetailsDAO){

        InstructorEntity instructorEntity = new InstructorEntity(
                "Mathew",
                "Francis",
                25
        );

        instructorDetailsDAO.saveInstructor(instructorEntity);

    }
}
