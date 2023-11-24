package com.story.StoryProject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackgroundRepository extends CrudRepository<Background, Long> {
	List<Background> findByName (String name);
}