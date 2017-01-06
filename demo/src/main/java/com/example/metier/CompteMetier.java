package com.example.metier;

import com.example.entities.Compte;

public interface CompteMetier {
	
	public Compte savecompte(Compte cp);
	public Compte getcompte(String code);

}
