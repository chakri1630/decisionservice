package com.activeweb.decisionservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.activeweb.decisionservice.rowmapper.DecisionScoreMapper;

@Repository
public class ScoreDecisionRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Integer getLoanAmount(Integer score) {

		return jdbcTemplate.queryForObject("select * from score_decision where score=?", new Object[] { score },
				new DecisionScoreMapper());

	}

}
