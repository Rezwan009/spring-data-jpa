package com.rezocoding.jpa.repositories;

import com.rezocoding.jpa.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video,Integer> {
}
