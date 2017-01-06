package com.example.metier;

import java.util.Date;

import com.example.dao.CompteRepository;
import com.example.dao.EmployeRepository;
import com.example.dao.OperationRepository;
import com.example.entities.Compte;
import com.example.entities.Employee;
import com.example.entities.Operation;
import com.example.entities.Retrait;
import com.example.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationMetierImpl implements OperationMetier{
	@Autowired
	private OperationRepository operatiorepesitory;
	@Autowired
	private CompteRepository compterepository;
	@Autowired
	private EmployeRepository employerepository;

	@Override
	@Transactional
	public boolean verser(String code, double montant, Long codeemp) {
		// TODO Auto-generated method stub
		Compte cp=compterepository.findOne(code);
		Employee e=employerepository.findOne(codeemp);
		Operation o = new Versement();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(e);
		operatiorepesitory.save(o);
		cp.setSolde(cp.getSolde()+montant);
		return true;
	}

	@Override
	@Transactional
	public boolean retirer(String code, double montant, Long codeemp) {
		// TODO Auto-generated method stub
		Compte cp=compterepository.findOne(code);
		if(cp.getSolde()<montant) throw new RuntimeException("solde insuffisant");
		Employee e=employerepository.findOne(codeemp);
		Operation o = new Retrait();
		o.setDateOperation(new Date());
		o.setMontant(montant);
		o.setCompte(cp);
		o.setEmploye(e);
		operatiorepesitory.save(o);
		cp.setSolde(cp.getSolde()-montant);
		return true;
	}

	@Override
	@Transactional
	public boolean virement(String cpte1, String cpte2, double montant, Long codeemp) {
		// TODO Auto-generated method stub
		retirer(cpte1, montant, codeemp);
		verser(cpte2, montant, codeemp);
		return true;
	}

	@Override
	public PageOperation getOperations(String codecompte, int page, int size) {
		// TODO Auto-generated method stub
		Page<Operation> ops=operatiorepesitory.getOperations(codecompte, new PageRequest(page, size));
		PageOperation pop = new PageOperation();
		pop.setOperations(ops.getContent());
		pop.setNombreOperations(ops.getNumberOfElements());
		pop.setPage(ops.getNumber());
		pop.setTotalpages(ops.getTotalPages());
		pop.setTotalOperations((int)ops.getTotalElements());
		return pop;
	}

}
