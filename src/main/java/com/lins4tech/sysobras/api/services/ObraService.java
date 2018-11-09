package com.lins4tech.sysobras.api.services;

import java.util.List;

import com.lins4tech.sysobras.api.entities.Obra;

public interface ObraService {
	
	/**
	 * Retorna todas as obras da construtora
	 * @param construtoraId
	 * @return
	 */
	List<Obra> findByConstrutoraId(Long construtoraId);
	
	/**
	 * Consulta a tabela Obra pela coluna nomeObra e construtora.
	 * @param nomeObra
	 * @param construtoraId
	 * @return List<Obra>
	 */
	List<Obra> findByNomeObraAndConstrutoraId(String nomeObra, Long construtoraId);

}
