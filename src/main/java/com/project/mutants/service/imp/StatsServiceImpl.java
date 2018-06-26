package com.project.mutants.service.imp;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mutants.dao.HumanRepository;
import com.project.mutants.model.Human;
import com.project.mutants.model.Stats;
import com.project.mutants.service.HumanService;
import com.project.mutants.service.StatsService;

@Service
public class StatsServiceImpl implements StatsService {

	@Autowired
	protected HumanRepository humanRepository;
	
	@Autowired
	protected HumanService humanService;
	
	
	/**
	 * Statistics Method
	 */
	@Override
	public Stats getStats() {
		
		double ratio = 0;
		String ratioFormat = "0";
		
		List<Human> humans = humanService.findAllHumans();
		List<Human> humansMutants = new ArrayList<>();
		
		for (Human human : humans) {
			if(human.isMutant()) {
				humansMutants.add(human);
			}
		}
		
		Integer countHumans = humans.size();
		Integer countMutants = humansMutants.size();
		
		if(countHumans>0) {
			ratio = (double) countMutants/countHumans;
			
			NumberFormat formatter = new DecimalFormat("#0.00"); 
			ratioFormat = formatter.format(ratio);
		}
		
		Stats stats= new Stats(countMutants, countHumans, ratioFormat);
		
		return stats;
	}

}
