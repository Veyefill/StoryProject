package com.story.StoryProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.story.StoryProject.domain.Background;
import com.story.StoryProject.domain.BackgroundRepository;
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

@SpringBootApplication
public class StoryProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoryProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BackgroundRepository backgroundRepository, CharacterRepository characterReposiotry,
			EyeColorRepository eyeColorRepository, GenderExpressionRepository genderExpressionRepository,
			HairColorRepository hairColorRepository, PronounsRepository pronounsRepository,
			RaceRepository raceRepository) {
		return (args) -> {
			
			//Backgrounds
			Background b0 = new Background("Default");
			Background b1 = new Background("Prisoner");
			Background b2 = new Background("Guard");
			Background b3 = new Background("Adventurer");

			backgroundRepository.save(b0);
			backgroundRepository.save(b1);
			backgroundRepository.save(b2);
			backgroundRepository.save(b3);

			//EyeColor
			EyeColor e1 = new EyeColor("Blue");
			EyeColor e2 = new EyeColor("Green");
			EyeColor e3 = new EyeColor("Brown");

			eyeColorRepository.save(e1);
			eyeColorRepository.save(e2);
			eyeColorRepository.save(e3);

			//GenderExpression
			GenderExpression g1 = new GenderExpression("Feminine");
			GenderExpression g2 = new GenderExpression("Masculine");
			GenderExpression g3 = new GenderExpression("Androgynous");

			genderExpressionRepository.save(g1);
			genderExpressionRepository.save(g2);
			genderExpressionRepository.save(g3);
			
			//Hair Color
			HairColor h1 = new HairColor("Brown");
			HairColor h2 = new HairColor("Blonde");
			HairColor h3 = new HairColor("Black");

			hairColorRepository.save(h1);
			hairColorRepository.save(h2);
			hairColorRepository.save(h3);

			//Pronouns
			Pronouns p1 = new Pronouns("He/Him");
			Pronouns p2 = new Pronouns("She/Her");
			Pronouns p3 = new Pronouns("They/Them");

			pronounsRepository.save(p1);
			pronounsRepository.save(p2);
			pronounsRepository.save(p3);

			//Races
			Race r1 = new Race("Orc");
			Race r2 = new Race("Human");
			Race r3 = new Race ("Elf");
			
			raceRepository.save(r1);
			raceRepository.save(r2);
			raceRepository.save(r3);
		};
	}
}