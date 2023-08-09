package com.example.instructordetailsprocject.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "course" ,uniqueConstraints = @UniqueConstraint(name= "uniqueThing",columnNames = "instructor_id"))
public class CoursesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "subject")
    private String subject;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            }
    )
    @JoinColumn(name = "instructor_id")
    private InstructorEntity instructorEntity;

    public InstructorEntity getInstructorEntity() {
        return instructorEntity;
    }

    public void setInstructorEntity(InstructorEntity instructorEntity) {
        this.instructorEntity = instructorEntity;
    }

    public CoursesEntity(){}

    public CoursesEntity(String subject) {
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
