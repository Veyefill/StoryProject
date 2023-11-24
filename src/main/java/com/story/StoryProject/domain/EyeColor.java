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
@Table(name = "eyecolor")
public class EyeColor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String color;
	
	@OneToMany(mappedBy = "eyecol", cascade = CascadeType.ALL)
	private List<Character> characters;
	
	public EyeColor () {
		
	}
	
	public EyeColor (String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
}