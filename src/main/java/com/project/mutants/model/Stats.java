package com.project.mutants.model;

import java.io.Serializable;

public class Stats implements Serializable{
	
	private static final long serialVersionUID = 5179110920066251599L;
	
	private long count_mutant_dna;
    private long count_human_dna;
    private String ratio;

    public Stats(long mutants, long humans, String ratio) {
    	super();
        this.count_mutant_dna = mutants;
        this.count_human_dna = humans;
        this.ratio = ratio;
    }
    
	public Stats() {
		super();
	}

    public String toString() {
        return "[mutants: " + count_mutant_dna + ", humans: " + count_human_dna + ", ratio: " + ratio + "]";
    }

	public long getCount_mutant_dna() {
		return count_mutant_dna;
	}

	public void setCount_mutant_dna(long count_mutant_dna) {
		this.count_mutant_dna = count_mutant_dna;
	}

	public long getCount_human_dna() {
		return count_human_dna;
	}

	public void setCount_human_dna(long count_human_dna) {
		this.count_human_dna = count_human_dna;
	}

	public String getRatio() {
		return ratio;
	}

	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
}
