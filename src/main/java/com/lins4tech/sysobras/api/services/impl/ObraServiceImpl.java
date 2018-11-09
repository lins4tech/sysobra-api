package com.lins4tech.sysobras.api.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lins4tech.sysobras.api.entities.Obra;
import com.lins4tech.sysobras.api.repositories.ObraRepository;
import com.lins4tech.sysobras.api.services.ObraService;

public class ObraServiceImpl implements ObraService {
	
	private static final Logger log = LoggerFactory.getLogger(ObraServiceImpl.class);
	
	@Autowired
	private ObraRepository obraRepository;

	@Override
	public List<Obra> findByConstrutoraId(Long construtoraId) {
		log.info("Buscando uma obras por construtora id {}", construtoraId);
		return this.obraRepository.findByConstrutoraId(construtoraId);
	}

	@Override
	public List<Obra> findByNomeObraAndConstrutoraId(String nomeObra, Long construtoraId) {
		log.info("Buscando uma obras por nomeObra e construtora id: {} {}", nomeObra, construtoraId);
		return this.obraRepository.findByNomeObraLikeAndConstrutoraId(nomeObra, construtoraId);
	}

}
