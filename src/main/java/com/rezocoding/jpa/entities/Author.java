package com.rezocoding.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@NamedQuery(
        name = "Author.findByNamedQuery",
        query="select a from Author a where a.age >= :age"
)
@NamedQuery(
        name = "Author.updateByNamedQuery",
        query="update Author a set a.age = :age"
)
public class Author extends BaseEntity{

    @Column(
            name = "first_name",
            length = 35
    )
    private String firstName;

    @Column(
            name = "last_name",
            length = 35
    )
    private String lastName;

    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    private int age;

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
