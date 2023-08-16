package com.example.instructordetailsprocject.restController;

import com.example.instructordetailsprocject.Entity.InstructorEntity;
import com.example.instructordetailsprocject.service.StudiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CourseRestController {
    private final StudiesService studiesService;

    public CourseRestController(@Autowired StudiesService studiesService){

        this.studiesService = studiesService;
    }


    @GetMapping("/data/alldata")
    public InstructorEntity getAllInstructorData(){

        InstructorEntity instructor = studiesService.onlyInstructor();

        //the bellow is done so that only fields with values are returned else jackson will throw an error
        instructor.getCourses().forEach(a -> {
            a.setInstructorEntity(null);
            a.setStudents(null);
        });
        //instructor.setAddressEntity(null);


        System.out.println("-".repeat(90));
        System.out.println("API hit "+instructor);

        return instructor;

    }

}
