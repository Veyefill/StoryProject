package com.story.StoryProject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderExpressionRepository extends CrudRepository<GenderExpression, Long> {
	List<GenderExpression> findByGenderExpression (String genderExpression);
}