package com.example.instructordetailsprocject.testCASE;

import com.example.instructordetailsprocject.DAO.InstructorDetailsDAO;
import com.example.instructordetailsprocject.Entity.AddressEntity;
import com.example.instructordetailsprocject.Entity.InstructorEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class apiTester {

    @Autowired
    InstructorDetailsDAO instructorDetailsDAO;

    private InstructorEntity instructorEntity;

    @BeforeEach
    public void startup(){
        instructorEntity = new InstructorEntity(
                "Mathew",
                "Francis",
                25
        );
    }


    @Test
    public void InstructorDetailsImplementationDAO_saveInstructor_trueReturn(){

/*        AddressEntity addressEntity = new AddressEntity(
                "E - 42/9 phase 2 cv Ramanagar ",
                560093
        );*/

        //instructorDetailsDAO.saveInstructor(instructorEntity);

        Assertions.assertThat(instructorEntity.getAge()).isEqualTo(25);

    }
    @Test
    public void InstructorDetailsImplementationDAO_fetchInstructor_returnAnInstructor(){

        Assertions.assertThat(instructorDetailsDAO.fetchInstructor(1)).isNotNull();
    }
}
