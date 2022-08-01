package com.project.mytube.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mytube.model.Channel;
import com.project.mytube.model.Video;
import com.project.mytube.repository.VideoRepository;

@Service
public class VideoService {

	@Autowired
	VideoRepository videoRepository;
	
	public void deleteVideo(int id) {
		Video video = videoRepository.findById(id).get();
		videoRepository.delete(video);
	}
	
	
	public Channel fetchChannel(int id) {
		Video video = videoRepository.findById(id).get();
		Channel channel = null;
		if(video != null) {
			 channel = video.getChannel();
		}
		
		return channel;
	}
}
