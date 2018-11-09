package com.lins4tech.sysobras.api.services;

import java.util.Optional;

import com.lins4tech.sysobras.api.entities.Construtora;

public interface ConstrutoraService {

	/**
	 * Consultar construtora por cnpj
	 * @param cnpj
	 * @return Optional<Construtora>
	 */
	Optional<Construtora> findByCnpj(String cnpj);
	
	/**
	 * Persiste uma nova construtora no banco de dados.
	 * @param construtora
	 * @return Construtora
	 */
	Construtora persist(Construtora construtora);
}
