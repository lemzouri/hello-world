package com.example.metier;

import java.util.Date;

import com.example.dao.CompteRepository;
import com.example.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CompteMetierImpl implements CompteMetier {
    @Autowired
	private CompteRepository compterepository;
	@Override
	public Compte savecompte(Compte cp) {
		// TODO Auto-generated method stub
		cp.setDatecreation(new Date());
		return compterepository.save(cp);
	}

	@Override
	public Compte getcompte(String code) {
		// TODO Auto-generated method stub
		return compterepository.findOne(code);
	}

}
