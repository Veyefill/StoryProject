package com.story.StoryProject.web;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
import com.story.StoryProject.domain.ProgramUser;
import com.story.StoryProject.domain.ProgramUserRepository;

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

	@Autowired
	private ProgramUserRepository programUserRepository;

	public StoryController(BackgroundRepository backgroundRepository, CharacterRepository characterRepository,
			EyeColorRepository eyeColorRepository, GenderExpressionRepository genderExpressionRepository,
			HairColorRepository hairColorRepository, PronounsRepository pronounsRepository,
			RaceRepository raceRepository, ProgramUserRepository userRepository) {
		this.backgroundRepository = backgroundRepository;
		this.characterRepository = characterRepository;
		this.eyeColorRepository = eyeColorRepository;
		this.genderExpressionRepository = genderExpressionRepository;
		this.hairColorRepository = hairColorRepository;
		this.pronounsRepository = pronounsRepository;
		this.raceRepository = raceRepository;

	}

	// Menu

	@GetMapping("/menu")
	public String menu(Model model, Principal principal, ProgramUser programUser) {
		String username = principal.getName();
		ProgramUser owner = programUserRepository.findByUsername(username);
		Optional<Character> character = characterRepository.findByProgramUser(owner);
		model.addAttribute("character", character);
		ProgramUser currentUser = programUserRepository.findByUsername(username);
		model.addAttribute("currentUser", currentUser);
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

	// Character

	@GetMapping("/character/customiser")
	public String showCharacterCreation(Model model) {
		model.addAttribute("character", new Character());
		Iterable<Background> background = backgroundRepository.findAll();
		model.addAttribute("background", background);
		Iterable<EyeColor> eyeColor = eyeColorRepository.findAll();
		model.addAttribute("eyeColor", eyeColor);
		Iterable<GenderExpression> genderExpression = genderExpressionRepository.findAll();
		model.addAttribute("genderExpression", genderExpression);
		Iterable<HairColor> hairColor = hairColorRepository.findAll();
		model.addAttribute("hairColor", hairColor);
		Iterable<Pronouns> pronouns = pronounsRepository.findAll();
		model.addAttribute("pronouns", pronouns);
		Iterable<Race> race = raceRepository.findAll();
		model.addAttribute("race", race);
		return "charcreation";
	}

	@PostMapping("/character/customiser")
	public String createCharacter(@ModelAttribute Character character, Principal principal) {
		String username = principal.getName();
		ProgramUser programUser = programUserRepository.findByUsername(username);
		character.setProgramUser(programUser);
		characterRepository.save(character);
		return "createdcharacter";
	}

	@GetMapping("/character/show")
	public String showCharacter(Model model, Principal principal) {
		ProgramUser owner = programUserRepository.findByUsername(principal.getName());
		Optional<Character> character = characterRepository.findByProgramUser(owner);
		model.addAttribute("character", character);
		return "showcharacter";
	}

	@Transactional
	@PostMapping("/character/delete")
	public String deleteCharacter(Principal principal) {
		ProgramUser owner = programUserRepository.findByUsername(principal.getName());
		characterRepository.deleteByProgramUser(owner);
		return "redirect:/menu";
	}

	// Story - Mutual

	@GetMapping("/introduction") // Opening the correct introduction
	public String introduction(Principal principal, Background background, Model model) {
		ProgramUser owner = programUserRepository.findByUsername(principal.getName());
		Optional<Character> character = characterRepository.findByProgramUser(owner);
		model.addAttribute("character", character);
		String introduction = character.get().getBackground().getName() + "intro";
		return introduction;

	}

	@GetMapping("/end")
	public String end(Principal principal, Model model) {
		ProgramUser programUser = programUserRepository.findByUsername(principal.getName());
		Optional<Character> character = characterRepository.findByProgramUser(programUser);
		model.addAttribute("character", character);
		model.addAttribute("programUser", programUser);
		return "end";
	}

	// Story - Adventurer Background
	@GetMapping("/atradingship")
	public String aTradingShip(Principal principal, Model model) {
		ProgramUser owner = programUserRepository.findByUsername(principal.getName());
		Optional<Character> character = characterRepository.findByProgramUser(owner);
		model.addAttribute("character", character);
		return "atradingship";
	}

	@GetMapping("/afishingboat")
	public String aFishingBoat(Principal principal, Model model) {
		ProgramUser owner = programUserRepository.findByUsername(principal.getName());
		Optional<Character> character = characterRepository.findByProgramUser(owner);
		model.addAttribute("character", character);
		return "afishingboat";
	}

	// Story - Prisoner Background
	@GetMapping("/pcelllockpick")
	public String pCellLockpick(Principal principal, Model model) {
		ProgramUser owner = programUserRepository.findByUsername(principal.getName());
		Optional<Character> character = characterRepository.findByProgramUser(owner);
		model.addAttribute("character", character);
		return "pcelllockpick";
	}

	@GetMapping("/pcellmetalbar")
	public String pCellMetalBar(Principal principal, Model model) {
		ProgramUser owner = programUserRepository.findByUsername(principal.getName());
		Optional<Character> character = characterRepository.findByProgramUser(owner);
		model.addAttribute("character", character);
		return "pcellmetalbar";
	}
	
	// Story - Guard Background
	@GetMapping("/grallyguards")
	public String pGRallyGuards(Principal principal, Model model) {
		ProgramUser owner = programUserRepository.findByUsername(principal.getName());
		Optional<Character> character = characterRepository.findByProgramUser(owner);
		model.addAttribute("character", character);
		return "grallyguards";
	}
	
	@GetMapping("/ginvestigatesmoke")
	public String pGInvestigateSmoke(Principal principal, Model model) {
		ProgramUser owner = programUserRepository.findByUsername(principal.getName());
		Optional<Character> character = characterRepository.findByProgramUser(owner);
		model.addAttribute("character", character);
		return "ginvestigatesmoke";
	}

	// Saving

	@GetMapping("/continue")
	public String continueStory(Principal principal, Model model) {
		ProgramUser owner = programUserRepository.findByUsername(principal.getName());
		Optional<Character> character = characterRepository.findByProgramUser(owner);
		model.addAttribute("character", character);
		String progress = character.get().getProgress();
		if (progress == null || progress == "continue") {
			return "uhoh";
		} else {
			String fixedProgress = progress.toLowerCase();
			return fixedProgress;
		}
	}

	@PostMapping("/save/introduction")
	public String saveIntroduction(Principal principal) {
		ProgramUser owner = programUserRepository.findByUsername(principal.getName());
		Optional<Character> characterExists = characterRepository.findByProgramUser(owner);
		Character character = characterExists.get();
		String progress = character.getBackground().getName() + "intro";
		character.setProgress(progress);
		characterRepository.save(character);
		return "redirect:/introduction";
	}
	
	//Saving - Prisoner
	@PostMapping("/save/pcellmetalbar")
	public String savePCellMetalBar(Principal principal) {
		ProgramUser owner = programUserRepository.findByUsername(principal.getName());
		Optional<Character> characterExists = characterRepository.findByProgramUser(owner);
		Character character = characterExists.get();
		character.setProgress("pcellmetalbar");
		characterRepository.save(character);
		return "redirect:/pcellmetalbar";
	}
	
	@PostMapping("/save/pcelllockpick")
	public String savePCellLockpick(Principal principal) {
		ProgramUser owner = programUserRepository.findByUsername(principal.getName());
		Optional<Character> characterExists = characterRepository.findByProgramUser(owner);
		Character character = characterExists.get();
		character.setProgress("pcelllockpick");
		characterRepository.save(character);
		return "redirect:/pcelllockpick";
	}
	
	//Saving - Adventurer
	@PostMapping("/save/atradingship")
	public String saveATradingShip(Principal principal) {
		ProgramUser owner = programUserRepository.findByUsername(principal.getName());
		Optional<Character> characterExists = characterRepository.findByProgramUser(owner);
		Character character = characterExists.get();
		character.setProgress("atradingship");
		characterRepository.save(character);
		return "redirect:/atradingship";
	}
	
	@PostMapping("/save/afishingboat")
	public String saveAFishingBoat(Principal principal) {
		ProgramUser owner = programUserRepository.findByUsername(principal.getName());
		Optional<Character> characterExists = characterRepository.findByProgramUser(owner);
		Character character = characterExists.get();
		character.setProgress("afishingboat");
		characterRepository.save(character);
		return "redirect:/afishingboat";
	}
	
	//Saving - Guard
	@PostMapping("/save/grallyguards")
	public String saveGRallyGuards(Principal principal) {
		ProgramUser owner = programUserRepository.findByUsername(principal.getName());
		Optional<Character> characterExists = characterRepository.findByProgramUser(owner);
		Character character = characterExists.get();
		character.setProgress("grallyguards");
		characterRepository.save(character);
		return "redirect:/grallyguards";
	}
	
	@PostMapping("/save/ginvestigatesmoke")
	public String saveGInvestigateSmoke(Principal principal) {
		ProgramUser owner = programUserRepository.findByUsername(principal.getName());
		Optional<Character> characterExists = characterRepository.findByProgramUser(owner);
		Character character = characterExists.get();
		character.setProgress("ginvestigatesmoke");
		characterRepository.save(character);
		return "redirect:/ginvestigatesmoke";
	}


	// Logging in

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

}