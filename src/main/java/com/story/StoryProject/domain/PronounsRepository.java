package com.story.StoryProject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PronounsRepository extends CrudRepository<Pronouns, Long> {
	List<Pronouns> findByPronouns (String pronouns);
}