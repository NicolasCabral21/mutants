package com.project.mutants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.project.mutants.model.DnaSequence;
import com.project.mutants.model.Human;
import com.project.mutants.model.Stats;
import com.project.mutants.service.HumanService;
import com.project.mutants.service.imp.HumanServiceImpl;
import com.project.mutants.util.RestResponse;

public class MutantTest {

	HumanService humanService;
	
	@Test
	public void isMutant() {
		
		humanService = new HumanServiceImpl();
		
		// is Mutant
		String[] dnaMutantArray =  new String[] {	"ATGCGA",
													"CAGTGC",
													"TTATGT",
													"AGAAGG",
													"CCCCTA",
													"TCACTG"};
		
		DnaSequence dnaSequenceMutant = new DnaSequence();
		
		List<String> dnaMutant = new ArrayList<>();
		
		for(int i= 0 ; i < dnaMutantArray.length ; i++) {
			dnaMutant.add(dnaMutantArray[i]);
		}
		
		dnaSequenceMutant.setDna(dnaMutant);
		
		assertTrue(humanService.isMutant(dnaSequenceMutant));
		
		// Is Human
		String[] dnaHumanArray =  new String[] {	"ATGCGA", 
													"CAGTGC", 
													"TTATTT", 
													"AGACGG",
													"GCGTCA",
													"TCACTG"};

		DnaSequence dnaSequenceHuman = new DnaSequence();
		List<String> dnaHuman = new ArrayList<>();
		
		for(int i= 0 ; i < dnaHumanArray.length ; i++) {
			dnaHuman.add(dnaHumanArray[i]);
		}
		dnaSequenceHuman.setDna(dnaHuman);
		
		assertFalse(humanService.isMutant(dnaSequenceHuman));
	}
	
	@Test
	public void createStats() {
		Stats stats = new Stats();
		stats.setCount_human_dna(2L);
		stats.setCount_mutant_dna(1L);
		stats.setRatio("2");
		stats.toString();
		
		Stats stats2 = new Stats(2L, 1L, "2");
		
		assertEquals(stats.getCount_human_dna(), 2L);
		assertEquals(stats.getCount_mutant_dna(), 1L);
		assertEquals(stats.getRatio(), "2");
		
		assertNotNull(stats);
		assertNotNull(stats2);
	}
	
	@Test
	public void createHuman() {
		
		Human human = new Human();
		human.setId(1L);
		human.setDna("[ATGCGA, CAGTGC, TTATTT, AGACGG, GCGTCA, TCACTG]");
		human.setMutant(false);
		
		assertNotNull(human.getId());
		assertNotNull(human.getDna());
		assertNotNull(human.isMutant());
	}
	
	@Test
	public void restResponse() {
		RestResponse rr = new RestResponse(200);
		rr.setMessage("Success");
		rr.setResponseCode(200);
		
		RestResponse r_r = new RestResponse(403,"Forbidden");
		r_r.setMessage("Forbidden");
		
		assertNotNull(rr.getResponseCode());
		assertEquals(r_r.getMessage(),"Forbidden");
	}
}
