package com.project.mutants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.mutants.model.Stats;
import com.project.mutants.service.StatsService;

@RestController
public class StatsController {
	
	@Autowired
	StatsService statsService;

	@RequestMapping(value="/stats", method = RequestMethod.GET)
	public Stats getStats(){
		
		Stats stats= statsService.getStats();
		
		return stats;
	}
}
