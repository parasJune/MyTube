package com.project.mytube.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.*;
import com.project.mytube.model.Channel;
import com.project.mytube.model.Video;
import com.project.mytube.service.ChannelService;
import com.project.mytube.service.VideoService;

@Controller
public class VideoController {
	
	@Autowired
	ChannelService channelService;
	
	@Autowired
	VideoService videoService;
	
	@GetMapping("channel/{id}")
	public String showChannelPage(@PathVariable("id") String id,Model model) {
		Channel channel = channelService.getChannel(Integer.parseInt(id));
		model.addAttribute("channel", channel);
		model.addAttribute("videos", channel.getListOfVideos());
		return "Channel";
	}

	@GetMapping("/channel/add-videos/{id}")
	public String getAddVideosPage(@PathVariable("id") String id,Model model) {
		Channel channel = channelService.getChannel(Integer.parseInt(id));
		model.addAttribute("channel", channel);
		model.addAttribute("video", new Video(-123,"","",channel));
		return "AddVideo";
	}
	
	@PostMapping("/channel/add-videos/{id}")
	public String postAddVideosPage(@PathVariable("id") String id,Model model,Video video) {
		Channel channel = channelService.getChannel(Integer.parseInt(id));
		List<Video> listOfVideos = new ArrayList<>();
		
		String youtubeEmbededLink = "https://www.youtube.com/embed/"; 
		String videoKey = video.getVideoLink().split("=")[1];
		video.setVideoLink(youtubeEmbededLink+videoKey);
		listOfVideos.add(video);
		channel.setListOfVideos(listOfVideos);
		video.setChannel(channel);
		System.out.println(channel);
		System.out.println(video);
		channelService.saveChannel(channel);
		return "redirect:/channel/"+channel.getId();
	}
	
	@GetMapping("/channel/delete-video/{id}")
	public String deleteVideo(@PathVariable("id")String id) {
		Channel channel = videoService.fetchChannel(Integer.parseInt(id));
		videoService.deleteVideo(Integer.parseInt(id));
		if(channel != null) {
			return "redirect:/channel/"+channel.getId();
		}
		 return "redirect:/";
	}
}
