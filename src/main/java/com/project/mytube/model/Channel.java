package com.project.mytube.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Channel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;
	
	public String name;
	
	public String description;
		  
	  private String imageAddress;
	
		public String getImageAddress() {
		return imageAddress;
	}

	public void setImageAddress(String imageAddress) {
		this.imageAddress = imageAddress;
	}

		

	@OneToMany(mappedBy="channel",cascade = CascadeType.ALL)
	public List<Video> listOfVideos;
	
	

	

	

	public Channel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Channel(Integer id, String name, String description, String imageAddress, List<Video> listOfVideos) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageAddress = imageAddress;
		this.listOfVideos = listOfVideos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Video> getListOfVideos() {
		return listOfVideos;
	}

	public void setListOfVideos(List<Video> listOfVideos) {
		this.listOfVideos = listOfVideos;
	}

	@Override
	public String toString() {
		return "Channel [id=" + id + ", name=" + name + ", description=" + description + ", listOfVideos="
				+ listOfVideos + "]";
	}
	
	
	
	

}
