package com.example.instructordetailsprocject.service;

import com.example.instructordetailsprocject.DAO.InstructorDetailsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudiesService {

    InstructorDetailsDAO instructorDetailsDAO;

    @Autowired
    public StudiesService(InstructorDetailsDAO instructorDetailsDAO) {
        this.instructorDetailsDAO = instructorDetailsDAO;
    }
}
