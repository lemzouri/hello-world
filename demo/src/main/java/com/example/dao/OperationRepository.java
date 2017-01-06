package com.example.dao;

import com.example.entities.Compte;
import com.example.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operation, Long> {
	
	@Query("select o from Operation o where o.compte.codecompte=:x")
	public Page<Operation> getOperations(@Param("x")String code,Pageable pageable);


	//public Page<Operation> findByCompte(Compte cp,Pageable pageable);

}
