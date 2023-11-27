package com.story.StoryProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
	
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private ProgramUser programUser;

	@ManyToOne
	@JoinColumn(name = "race_id")
	private Race race;

	@ManyToOne
	@JoinColumn(name = "pronouns_id")
	private Pronouns pronouns;

	@ManyToOne
	@JoinColumn(name = "genderexpression_id")
	private GenderExpression gendexp; // Gender expression

	@ManyToOne
	@JoinColumn(name = "haircolor_id")
	private HairColor haircol; // Hair color

	@ManyToOne
	@JoinColumn(name = "eyecolor_id")
	private EyeColor eyecol; // Eye color

	private int height; // Height has a set range depending on race

	@ManyToOne
	@JoinColumn(name = "background_id")
	private Background background;

	public Character() {
	}

	public Character(String firstName, String lastName, int age, Race race, Pronouns pronouns, GenderExpression gendexp,
			HairColor haircol, EyeColor eyecol, int height, Background background) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.race = race;
		this.pronouns = pronouns;
		this.gendexp = gendexp;
		this.haircol = haircol;
		this.eyecol = eyecol;
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
	public GenderExpression getGendexp() {
		return gendexp;
	}

	public void setGendexp(GenderExpression gendexp) {
		this.gendexp = gendexp;
	}

	// Hair Color
	public HairColor getHaircol() {
		return haircol;
	}

	public void setHaircol(HairColor haircol) {
		this.haircol = haircol;
	}

	// Eye Color
	public EyeColor getEyecol() {
		return eyecol;
	}

	public void setEyecol(EyeColor eyecol) {
		this.eyecol = eyecol;
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
	
	//User
	public ProgramUser getProgramUser() {
		return programUser;
	}
	
	public void setProgramUser(ProgramUser programUser) {
		this.programUser = programUser;
	}
	
}
