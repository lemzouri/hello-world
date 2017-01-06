package com.example.metier;

import java.util.List;

import com.example.entities.Client;

public interface ClientMetier {
	
	public Client saveClient(Client c);
	public List<Client> listClient();

}
