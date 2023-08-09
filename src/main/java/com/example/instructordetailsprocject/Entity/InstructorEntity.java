package com.example.instructordetailsprocject.Entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "instructor")
public class InstructorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @OneToOne(
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            },
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "adress_id")
    private AddressEntity addressEntity;

    @OneToMany(mappedBy = ("instructorEntity"),
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH,
            }
    )
    private List<CoursesEntity> courses;

    public InstructorEntity() {
    }

    public InstructorEntity(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public List<CoursesEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CoursesEntity> courses) {
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    //convenience method;

    public void addAnAddress(AddressEntity addressEntity){

        Objects.requireNonNull(addressEntity);

        this.addressEntity = addressEntity;

    }

    public void addACourse(CoursesEntity course){

        Objects.requireNonNull(course);

        course.setInstructorEntity(this);

        this.courses.add(course);

    }

    @Override
    public String toString() {
        return "InstructorEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", addressEntity=" + addressEntity +
                '}';
    }
}
