package com.project.mutants.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.mutants.model.Human;
import com.project.mutants.service.HumanService;

@RestController
public class HumanController {

	@Autowired
	HumanService humanService;
	
	@RequestMapping(value="/humans", method= RequestMethod.GET)
	public List<Human> getHumans() {
		return this.humanService.findAllHumans();
	}
}
