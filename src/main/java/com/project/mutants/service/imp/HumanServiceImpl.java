package com.project.mutants.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mutants.dao.HumanRepository;
import com.project.mutants.model.DnaSequence;
import com.project.mutants.model.Human;
import com.project.mutants.service.HumanService;
import com.project.mutants.util.Detector;

@Service
public class HumanServiceImpl implements HumanService {

	@Autowired
	protected HumanRepository humanRepository;
	
	private Detector detector;
	
	private final static String[] DNA_SEQUENCES = {"AAAA", "CCCC","GGGG","TTTT"};
	
	@Override
	public List<Human> findAllHumans() {
		return humanRepository.findAll();
	}

	@Override
	public Human save(Human human) {
		return this.humanRepository.save(human);
	}

	@Override
	public boolean isMutant(DnaSequence dna) {
		
		detector = new Detector();
		
		boolean isMutant = false;
		
		Integer sizeDna = dna.getDna().size();
		
		char[][] matrixDna = new char[sizeDna][sizeDna]; 
		
		for (int i = 0; i < dna.getDna().size(); i++) {
			for (int j = 0; j < dna.getDna().get(i).length(); j++) {
				matrixDna[i][j] = dna.getDna().get(i).charAt(j);
			}
		}
		
		detector.setMatrix(matrixDna);
		detector.showMatrix();
		
		int conuntAdn = 0;
		for (int i = 0; i < DNA_SEQUENCES.length; i++) {
			if(detector.isMutant(DNA_SEQUENCES[i])) {
				conuntAdn++;
			}
		}
		
		if(conuntAdn>1)
			isMutant = true;
		
		return isMutant;
	}

}
