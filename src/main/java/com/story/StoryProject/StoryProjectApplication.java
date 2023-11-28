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
import com.story.StoryProject.domain.ProgramUser;
import com.story.StoryProject.domain.ProgramUserRepository;

@SpringBootApplication
public class StoryProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoryProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BackgroundRepository backgroundRepository, CharacterRepository characterReposiotry,
			EyeColorRepository eyeColorRepository, GenderExpressionRepository genderExpressionRepository,
			HairColorRepository hairColorRepository, PronounsRepository pronounsRepository,
			RaceRepository raceRepository, ProgramUserRepository programUserRepository) {
		return (args) -> {

			// Backgrounds
			Background b1 = new Background("Prisoner",
					"You're a prisoner in the infamous Ravenrock prison. You've been here so long you don't even know what you did, but now's the time to escape.");
			Background b2 = new Background("Guard",
					"You're a guard in the humble village of Orswen. While most days are calm, you can't help but notice black smoke approaching the city in the distance");
			Background b3 = new Background("Adventurer",
					"You don't have a constant place of residence- you wander from kingdom to kingdom, from land to land, seeking adventure.");

			backgroundRepository.save(b1);
			backgroundRepository.save(b2);
			backgroundRepository.save(b3);

			// EyeColor
			EyeColor e1 = new EyeColor("Blue");
			EyeColor e2 = new EyeColor("Green");
			EyeColor e3 = new EyeColor("Brown");

			eyeColorRepository.save(e1);
			eyeColorRepository.save(e2);
			eyeColorRepository.save(e3);

			// GenderExpression
			GenderExpression g1 = new GenderExpression("Androgynous");
			GenderExpression g2 = new GenderExpression("Feminine");
			GenderExpression g3 = new GenderExpression("Masculine");

			genderExpressionRepository.save(g1);
			genderExpressionRepository.save(g2);
			genderExpressionRepository.save(g3);

			// Hair Color
			HairColor h1 = new HairColor("Brown");
			HairColor h2 = new HairColor("Blonde");
			HairColor h3 = new HairColor("Black");


			hairColorRepository.save(h1);
			hairColorRepository.save(h2);
			hairColorRepository.save(h3);

			// Pronouns
			Pronouns p1 = new Pronouns("They/Them");
			Pronouns p2 = new Pronouns("He/Him");
			Pronouns p3 = new Pronouns("She/Her");

			pronounsRepository.save(p1);
			pronounsRepository.save(p2);
			pronounsRepository.save(p3);

			// Races
			Race r1 = new Race("Human", "Normal humans.");
			Race r2 = new Race("Orc",
					"Incredibly tall, brutish humanoid creatures. Most are incredibly tall and strong.");
			Race r3 = new Race("Elf",
					"Tall humanoids with pointed ears. They have a natural predisposition for being magic wielders.");

			raceRepository.save(r1);
			raceRepository.save(r2);
			raceRepository.save(r3);

			// Test login data
			
			ProgramUser u0 = new ProgramUser("test", "$2y$10$PMgNMSXQjWiZR9FPGbsvXOmfuKuqjtZ760F/NEhGM70vvUs/G5md2", "test@gmail.com", "USER");
			ProgramUser u1 = new ProgramUser("admin", "$2y$10$pFRGcwvF3x6fBmgvp2922eAkdVs7MKZNo4/25GkvxvDDoAGe0pL3S", "admin@gmail.com", "ADMIN");
			ProgramUser u2 = new ProgramUser("cowner", "$2y$10$tuDTZAeP8OpvbJsn2pYXUOvI6rh4rv9Mh2x/6HHagDXgB8Sn6.Ure", "cowner@gmail.com", "USER");
			
			programUserRepository.save(u0);
			programUserRepository.save(u1);
			programUserRepository.save(u2);
		};
	}
}