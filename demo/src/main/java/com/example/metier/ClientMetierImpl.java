package com.example.metier;

import java.util.List;

import com.example.dao.ClientRepository;
import com.example.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ClientMetierImpl implements ClientMetier {
    @Autowired
	private ClientRepository ClientRepository;
	
	@Override
	public Client saveClient(Client c) {
		// TODO Auto-generated method stub
		return ClientRepository.save(c);
	}

	@Override
	public List<Client> listClient() {
		// TODO Auto-generated method stub
		return ClientRepository.findAll();
	}

}
