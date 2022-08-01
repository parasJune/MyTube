package com.project.mytube.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mytube.model.Channel;
import com.project.mytube.repository.ChannelRepository;



@Service
public class ChannelService  {
	
	@Autowired
	ChannelRepository channelRepository;
	
	public void saveChannel(Channel channel) {
		channelRepository.save(channel);
		
	}
	
	public List<Channel> retrieveAllChannels() {
		List<Channel> channel = channelRepository.findAll();
		return channel;
		
	}
	
	public Channel getChannel(int id) {
		Channel channel = channelRepository.findById(id).get();
		return channel;
		
	}

	public void deleteChannel(int id) {
		Channel channel = channelRepository.findById(id).get();
		channelRepository.delete(channel);
	}
}
