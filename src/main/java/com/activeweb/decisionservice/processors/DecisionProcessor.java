package com.activeweb.decisionservice.processors;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activeweb.css.service.CreditScoreService;
import com.activeweb.css.service.CreditScoreServiceImplService;
import com.activeweb.decisionservice.beans.Application;
import com.activeweb.decisionservice.beans.Decision;
import com.activeweb.decisionservice.repository.ScoreDecisionRepository;

@Service
public class DecisionProcessor {

	@Autowired
	private ScoreDecisionRepository repository;

	public Decision process(Application application) {
		
		CreditScoreServiceImplService cssis = new CreditScoreServiceImplService();
		CreditScoreService service  = cssis.getCreditScoreServiceImplPort();
		
		Integer creditScore = service.getScore(application.getSsn());
		
		Integer approvedAmount = repository.getLoanAmount(creditScore);
		
		Decision decision = new Decision();
		decision.setApprovedAmount(new BigDecimal(approvedAmount));
		decision.setApr(new BigDecimal(12.85));
		
		if(approvedAmount>=10000) {
			decision.setStatus("Approved");
		}else {
			decision.setStatus("Not Approved");
		}
		
		return decision;

	}

}
