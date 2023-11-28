package com.story.StoryProject.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {
	Optional<Character> findByLastName (String lastName);
	Optional<Character> findByProgramUser (ProgramUser programUser);
	
	@Modifying
	@Query("DELETE FROM Character c WHERE c.programUser = :programUser")
	void deleteByProgramUser(@Param("programUser") ProgramUser programUser);
}