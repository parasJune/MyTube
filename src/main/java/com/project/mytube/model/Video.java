package com.project.mytube.model;

import javax.persistence.*;

@Entity
public class Video {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer videoId;
	
	public String name;
	
	public String videoLink;
	
	@ManyToOne
    @JoinColumn(name="channel_id", nullable=false)
    private Channel channel;

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	

	public Integer getVideoId() {
		return videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	@Override
	public String toString() {
		return "Video [id=" + videoId + ", name=" + name + ", videoLink=" + videoLink + "]";
	}

	public Video(Integer videoId, String name, String videoLink, Channel channel) {
		super();
		this.videoId = videoId;
		this.name = name;
		this.videoLink = videoLink;
		this.channel = channel;
	}
	
	
	public Video() {
		
	}

}
