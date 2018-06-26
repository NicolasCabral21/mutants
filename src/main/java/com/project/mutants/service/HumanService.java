package com.project.mutants.service;

import java.util.List;

import com.project.mutants.model.DnaSequence;
import com.project.mutants.model.Human;

public interface HumanService {
	
	public boolean isMutant(DnaSequence dna);

	Human save(Human human);
	
	List<Human> findAllHumans();
}
