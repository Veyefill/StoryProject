package com.story.StoryProject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HairColorRepository extends CrudRepository<HairColor, Long> {
	List<HairColor> findByColor (String color);
}