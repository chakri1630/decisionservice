package com.activeweb.decisionservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.activeweb.decisionservice.beans.Application;
import com.activeweb.decisionservice.beans.Decision;
import com.activeweb.decisionservice.processors.DecisionProcessor;

@RestController
public class DecisionResource {

	@Autowired
	private DecisionProcessor processor;

	@RequestMapping(value = "/application", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Decision processApplication(@RequestBody Application application) {

		return processor.process(application);

	}

}
