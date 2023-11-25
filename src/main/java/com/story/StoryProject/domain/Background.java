package com.story.StoryProject.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "background")
public class Background {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "background", cascade = CascadeType.ALL)
	private List<Character> characters;

	public Background() {

	}
	
	public Background(String name, String description) {
		this.name = name;
		this.description = description;
	}


	// Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// Name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//Description
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
