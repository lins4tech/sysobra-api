package com.lins4tech.sysobras.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lins4tech.sysobras.api.entities.Construtora;
import com.lins4tech.sysobras.api.repositories.ConstrutoraRepository;
import com.lins4tech.sysobras.api.services.ConstrutoraService;

public class ConstrutoraServiceImpl implements ConstrutoraService {
	
	private static final Logger log = LoggerFactory.getLogger(ConstrutoraServiceImpl.class);
	
	@Autowired
	private ConstrutoraRepository construtoraRepository;

	@Override
	public Optional<Construtora> findByCnpj(String cnpj) {
		log.info("Buscando uma construtora por CNPJ {}", cnpj);
		return Optional.ofNullable(this.construtoraRepository.findByCnpj(cnpj));
	}

	@Override
	public Construtora persist(Construtora construtora) {
		log.info("Persistindo uma nova construtora: {}", construtora);
		return this.construtoraRepository.save(construtora);
	}

}
