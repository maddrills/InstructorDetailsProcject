package com.example.instructordetailsprocject.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "age")
    private int age;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH,
            }
    )
    @JoinTable(
            name = "course_students",
            joinColumns = @JoinColumn(name = "students_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<CoursesEntity> courses;

    public Student(){}

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<CoursesEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CoursesEntity> courses) {
        this.courses = courses;
    }

    //convenience method
    public void addACourse(CoursesEntity course){
        if(this.courses == null){
            courses = new ArrayList<>();
        }
        this.courses.add(course);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
