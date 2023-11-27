package com.story.StoryProject.domain; 	

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramUserRepository extends CrudRepository<ProgramUser, Long> {
	ProgramUser findByUsername(String username);
	Optional<ProgramUser> findById(Long id);
}