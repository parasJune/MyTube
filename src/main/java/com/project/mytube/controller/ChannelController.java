package com.project.mytube.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.mytube.model.Channel;
import com.project.mytube.model.Video;
import com.project.mytube.service.ChannelService;

@Controller
public class ChannelController {
	
	@Autowired
	ChannelService channelService;

	
	@GetMapping("/")
	public String showDisplayPage(Model model) {
		if(channelService.retrieveAllChannels() != null)
		model.addAttribute("channels",channelService.retrieveAllChannels());
		return "Welcome";
	}
	
	@GetMapping("/add-channel")
	public String getAddChannel(Model model) {
		List<Video> list = new ArrayList<>();
		model.addAttribute("channel", new Channel(-123,"","","",list));
		return "AddChannel";
	}
	
	@PostMapping("/add-channel")
	public String postAddChannel(Channel channel) throws IOException  {
		if(channel!=null) {
	        channelService.saveChannel(channel);
			
		}
		System.out.print("Channel value "+channel);
		return "redirect:/";
	}
	
	@GetMapping("/delete-channel/{id}")
	public String deleteChannel(@PathVariable("id")String id) {
		channelService.deleteChannel(Integer.parseInt(id));
		return "redirect:/";
	}
	
	@GetMapping("update-channel/{id}")
	public String updateChannel(@PathVariable("id")String id,Model model) {
		Channel channel = channelService.getChannel(Integer.parseInt(id));
		model.addAttribute("channel",channel);
		return "AddChannel";
	}
	

}
