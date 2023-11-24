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
@Table(name = "pronouns")
public class Pronouns {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String pronouns;
	
	@OneToMany(mappedBy = "pronouns", cascade = CascadeType.ALL)
	private List<Character> characters;
	
	public Pronouns () {
		
	}
	
	public Pronouns (String pronouns) {
		this.pronouns = pronouns;
	}
	
	public String getPronouns () {
		return pronouns;
	}
	
	public void setPronouns (String pronouns) {
		this.pronouns = pronouns;
	}
}
