package com.project.mutants.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.mutants.model.Human;

public interface HumanRepository extends JpaRepository<Human,Long>{

	@SuppressWarnings("unchecked")
	Human save(Human mutant);
}
