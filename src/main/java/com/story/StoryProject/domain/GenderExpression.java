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
@Table(name = "genderexpressions")
public class GenderExpression {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String genderExpression; // Gender expression

	@OneToMany(mappedBy = "genderExpression", cascade = CascadeType.ALL)
	private List<Character> characters;

	public GenderExpression() {

	}

	public GenderExpression(String genderExpression) {
		this.genderExpression = genderExpression;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGenderExpression() {
		return genderExpression;
	}

	public void setGenderExpression(String genderExpression) {
		this.genderExpression = genderExpression;
	}
}
