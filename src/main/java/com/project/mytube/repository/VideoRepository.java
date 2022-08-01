package com.project.mytube.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.mytube.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {

   
       
}