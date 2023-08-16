package com.example.instructordetailsprocject.service;

import com.example.instructordetailsprocject.DAO.InstructorDetailsDAO;
import com.example.instructordetailsprocject.Entity.InstructorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudiesService {

    InstructorDetailsDAO instructorDetailsDAO;

    @Autowired
    public StudiesService(InstructorDetailsDAO instructorDetailsDAO) {
        this.instructorDetailsDAO = instructorDetailsDAO;
    }

    public InstructorEntity instructorsAssociations(){

        return instructorDetailsDAO.fetchAllDataLikeAChain(1);

    }
    public InstructorEntity onlyInstructor(){
        return instructorDetailsDAO.fetchInstructor(1);
    }

}
