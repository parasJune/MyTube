package com.project.mytube.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.mytube.model.Channel;


@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer> {

   
       
}
