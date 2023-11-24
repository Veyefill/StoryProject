package com.story.StoryProject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StoryController {
	
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
}
