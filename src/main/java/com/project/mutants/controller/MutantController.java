package com.project.mutants.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.mutants.model.DnaSequence;
import com.project.mutants.model.Human;
import com.project.mutants.service.HumanService;
import com.project.mutants.util.RestResponse;

@RestController
public class MutantController {
	
	@Autowired
	HumanService humanService;
	
	private static Logger logger =  Logger.getGlobal();
	
	@RequestMapping("/")
	public String getIndexPage() {
		return "index";
	}
	
	@RequestMapping(value="/mutant", method= RequestMethod.POST)
	public RestResponse isMutant(@RequestBody DnaSequence dna) {
		
		boolean isMutant;
		
		try {
			isMutant = humanService.isMutant(dna);
			createHuman(dna, isMutant);
			
			if(isMutant) {
				return new RestResponse(HttpStatus.OK.value(),"Success");
			} else {
				return new RestResponse(HttpStatus.FORBIDDEN.value(),"Forbidden");
			}
		} catch (RuntimeException e) {
			logger.log(Level.ALL, e.getMessage());	
			return  new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Internal Server Error");
		}
	}
	
	
	/**
	 * Create Human Mutant or Not
	 * @param dna
	 * @param isMutant
	 */
	public void createHuman(DnaSequence dna, boolean isMutant) {
		Human human = new Human();
		human.setMutant(isMutant);
		human.setDna(dna.getDna().toString());
		
		humanService.save(human);
	}
}
