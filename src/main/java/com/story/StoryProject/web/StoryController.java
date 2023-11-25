package com.story.StoryProject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.story.StoryProject.domain.Background;
import com.story.StoryProject.domain.BackgroundRepository;
import com.story.StoryProject.domain.Character;
import com.story.StoryProject.domain.CharacterRepository;
import com.story.StoryProject.domain.EyeColor;
import com.story.StoryProject.domain.EyeColorRepository;
import com.story.StoryProject.domain.GenderExpression;
import com.story.StoryProject.domain.GenderExpressionRepository;
import com.story.StoryProject.domain.HairColor;
import com.story.StoryProject.domain.HairColorRepository;
import com.story.StoryProject.domain.Pronouns;
import com.story.StoryProject.domain.PronounsRepository;
import com.story.StoryProject.domain.Race;
import com.story.StoryProject.domain.RaceRepository;

@Controller
public class StoryController {

	@Autowired
	private BackgroundRepository backgroundRepository;

	@Autowired
	private CharacterRepository characterRepository;

	@Autowired
	private EyeColorRepository eyeColorRepository;

	@Autowired
	private GenderExpressionRepository genderExpressionRepository;

	@Autowired
	private HairColorRepository hairColorRepository;

	@Autowired
	private PronounsRepository pronounsRepository;

	@Autowired
	private RaceRepository raceRepository;

	public StoryController(BackgroundRepository backgroundRepository, CharacterRepository characterRepository,
			EyeColorRepository eyeColorRepository, GenderExpressionRepository genderExpressionRepository,
			HairColorRepository hairColorRepository, PronounsRepository pronounsRepository,
			RaceRepository raceRepository) {
		this.backgroundRepository = backgroundRepository;
		this.characterRepository = characterRepository;
		this.eyeColorRepository = eyeColorRepository;
		this.genderExpressionRepository = genderExpressionRepository;
		this.hairColorRepository = hairColorRepository;
		this.pronounsRepository = pronounsRepository;
		this.raceRepository = raceRepository;

	}

	@RequestMapping("/menu")
	public String menu() {
		return "menu";
	}

	@RequestMapping("/newgameguest")
	public String newgameguest() {
		return "newgameguest";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	@RequestMapping("/changelog")
	public String changelog() {
		return "changelog";
	}

	@RequestMapping("/introduction")
	public String intrudction() {
		return "introduction";
	}

	@GetMapping("/charCreation")
	public String showCharacterCreation(Model model) {
		model.addAttribute("character", new Character());
		Iterable<Background> backgrounds = backgroundRepository.findAll();
		model.addAttribute("backgrounds", backgrounds);
		Iterable<EyeColor> eyeColors = eyeColorRepository.findAll();
		model.addAttribute("eyeColors", eyeColors);
		Iterable<GenderExpression> genderExpressions = genderExpressionRepository.findAll();
		model.addAttribute("genderExpressions", genderExpressions);
		Iterable<HairColor> hairColors = hairColorRepository.findAll();
		model.addAttribute("hairColors", hairColors);
		Iterable<Pronouns> pronouns = pronounsRepository.findAll();
		model.addAttribute("pronouns", pronouns);
		Iterable<Race> races = raceRepository.findAll();
		model.addAttribute("races", races);
		return "charcreation";
	}
	
	@PostMapping("/charCreated")
	public String createCharacter(@ModelAttribute Character character) {
		characterRepository.save(character);
		return "redirect:/createdcharacter";
	}
}