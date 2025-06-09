package com.rezocoding.jpa.repositories;

import com.rezocoding.jpa.entites.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
}
