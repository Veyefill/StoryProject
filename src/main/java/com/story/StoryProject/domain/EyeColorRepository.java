package com.story.StoryProject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EyeColorRepository extends CrudRepository<EyeColor, Long> {
	List<EyeColor> findByColor (String color);
}