package com.project.mutants.model;

import java.io.Serializable;
import java.util.List;

public class DnaSequence implements Serializable {

	private static final long serialVersionUID = 6637887273862623621L;

	private List<String> dna;

	public List<String> getDna() {
		return dna;
	}

	public void setDna(List<String> dna) {
		this.dna = dna;
	}
	
	
	
}
