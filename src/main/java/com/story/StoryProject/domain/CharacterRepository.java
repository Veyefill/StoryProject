package com.story.StoryProject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {
	List<Character> findByLastName (String lastName);
}