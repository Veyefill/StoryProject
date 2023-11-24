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
	private String gendexp; //Gender expression
	
	@OneToMany(mappedBy = "gendexp", cascade = CascadeType.ALL)
	private List<Character> characters;
	
	public GenderExpression() {
		
	}
	
	public GenderExpression (String gendexp) {
		this.gendexp = gendexp;
		
	}
	
	public String getGendexp () {
		return gendexp;
	}
	
	public void setGendexp (String gendexp) {
		this.gendexp = gendexp;
	}
}
