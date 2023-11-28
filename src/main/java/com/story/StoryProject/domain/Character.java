package com.story.StoryProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "characters")
public class Character {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	private String lastName;
	private int age; // From 19 to 59

	@ManyToOne
	@JoinColumn(name = "user_id", unique = true)
	private ProgramUser programUser;

	@ManyToOne
	@JoinColumn(name = "race_id")
	private Race race;

	@ManyToOne
	@JoinColumn(name = "pronouns_id")
	private Pronouns pronouns;

	@ManyToOne
	@JoinColumn(name = "genderExpression_id")
	private GenderExpression genderExpression; // Gender expression

	@ManyToOne
	@JoinColumn(name = "haircolor_id")
	private HairColor hairColor; // Hair color

	@ManyToOne
	@JoinColumn(name = "eyecolor_id")
	private EyeColor eyeColor; // Eye color

	private int height; // Height has a set range depending on race

	@ManyToOne
	@JoinColumn(name = "background_id")
	private Background background;

	private String progress;

	public Character() {
	}

	public Character(String firstName, String lastName, int age, Race race, Pronouns pronouns, GenderExpression genderExpression,
			HairColor hairColor, EyeColor eyeColor, int height, Background background) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.race = race;
		this.pronouns = pronouns;
		this.genderExpression = genderExpression;
		this.hairColor = hairColor;
		this.eyeColor = eyeColor;
		this.height = height;
		this.background = background;
	}

	// Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// First name
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// Last name
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// Age
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// Race
	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	// Pronouns
	public Pronouns getPronouns() {
		return pronouns;
	}

	public void setPronouns(Pronouns pronouns) {
		this.pronouns = pronouns;
	}

	// Gender Expression
	public GenderExpression getGenderExpression() {
		return genderExpression;
	}

	public void setGenderExpression(GenderExpression genderExpression) {
		this.genderExpression = genderExpression;
	}

	// Hair Color
	public HairColor getHairColor() {
		return hairColor;
	}

	public void setHairColor(HairColor hairColor) {
		this.hairColor = hairColor;
	}

	// Eye Color
	public EyeColor getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(EyeColor eyeColor) {
		this.eyeColor = eyeColor;
	}

	// Height
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	// Background
	public Background getBackground() {
		return background;
	}

	public void setBackground(Background background) {
		this.background = background;
	}

	// User
	public ProgramUser getProgramUser() {
		return programUser;
	}

	public void setProgramUser(ProgramUser programUser) {
		this.programUser = programUser;
	}

	// Progress
	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

}
