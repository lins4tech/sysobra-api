package com.lins4tech.sysobras.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.lins4tech.sysobras.api.entities.Construtora;

public interface ConstrutoraRepository extends JpaRepository<Construtora, Long>{
	
	@Transactional(readOnly = true)
	Construtora findByCnpj(String cnpj);

}
