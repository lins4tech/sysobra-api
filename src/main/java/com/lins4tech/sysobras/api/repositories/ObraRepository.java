package com.lins4tech.sysobras.api.repositories;

import java.util.List;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lins4tech.sysobras.api.entities.Obra;

@NamedQueries({
	@NamedQuery(
			name = "ObraRepository.findByConstrutoraId",
			query = "SELECT obra FROM Obra obra WHERE obra.construtora.id = :construtoraId"),
	@NamedQuery(
			name = "ObraRepository.findByNomeObraLikeAndConstrutoraId",
			query = "SELECT obra FORM Obra obra WHERE obra.nomeObra LIKE '%' || :nomeObra || '%' AND obra.construtora.id = :construtoraId"
			)
})
public interface ObraRepository extends JpaRepository<Obra, Long>{
	
	List<Obra> findByNomeObraLikeAndConstrutoraId(String nomeObra, Long construtoraId);
	
	List<Obra> findByConstrutoraId(Long construtoraId);
	
}
