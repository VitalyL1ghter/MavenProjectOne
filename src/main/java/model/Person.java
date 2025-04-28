package model;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class Person {

    private String firstName;
    private String lastName;

    private Integer age;
    private String nationality;

    public Person() {
    }

    public Person(String firstName, String lastName, Integer age, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Person person)) return false;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(age, person.age) && Objects.equals(nationality, person.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, nationality);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("age=" + age)
                .add("nationality='" + nationality + "'")
                .toString();
    }

}