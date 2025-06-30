package com.rezocoding.jpa.repositories;

import com.rezocoding.jpa.entities.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {

    // find authors using named query
    @Transactional
    List<Author> findByNamedQuery(@Param("age") int age);

    // update authors using named query
    @Transactional
    @Modifying
    void updateByNamedQuery(@Param("age") int age);

    // update Author a set a.age = :age where a.id = :id
    @Query("update Author a set a.age = :age where a.id = :id")
    @Modifying
    @Transactional
    void updateAuthor(int age, int id);

    //  Use a Fetch Join in Query:
    @Query("SELECT a FROM Author a JOIN FETCH a.courses WHERE a.id = :id")
    Optional<Author> findAuthorWithCourses(@Param("id") Integer id);

    //  select * from authors where first_name = ''
    List<Author> findAllByFirstName(String fn);

    //  select * from authors where first_name = 'rez'
    List<Author> findAllByFirstNameIgnoreCase(String fn);

    //  select * from authors where first_name like '%rz%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

    //  select * from authors where first_name like 'rz%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);

    //  select * from authors where first_name like '%rz'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);

    //  select * from authors where first_name in ('rez','coding')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);
}
