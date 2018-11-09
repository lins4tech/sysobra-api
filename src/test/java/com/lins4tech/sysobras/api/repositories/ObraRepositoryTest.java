package com.lins4tech.sysobras.api.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.lins4tech.sysobras.api.entities.Construtora;
import com.lins4tech.sysobras.api.entities.Obra;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ObraRepositoryTest {
	
	@Autowired
	private ConstrutoraRepository construtoraRepository;
	
	@Autowired
	private ObraRepository obraRepository;
	
	private static final String CNPJ = "15009078000188";
	
	@Before
	public void setUp() throws Exception {
		Construtora construtora = new Construtora();
		construtora.setRazaoSocial("Construtora Exemplo");
		construtora.setCnpj(CNPJ);
		this.construtoraRepository.save(construtora);
		this.obraRepository.save(generateObra(construtora));
	}
	
	@After
	public final void tearDown() throws Exception {
		this.obraRepository.deleteAll();
		this.construtoraRepository.deleteAll();
	}
	
	@Test
	public void testFindByNomeObraAndConstrutoraId() {
		Construtora construtora = this.construtoraRepository.findByCnpj(CNPJ);
		List<Obra> obras = this.obraRepository.findByNomeObraLikeAndConstrutoraId("Obra Test", construtora.getId());
		assertEquals(1, obras.size());
	}
	
	@Test
	public void testFindByConstrutoraId() {
		Construtora construtora = this.construtoraRepository.findByCnpj(CNPJ);
		List<Obra> obras = this.obraRepository.findByConstrutoraId(construtora.getId());
		assertEquals(1, obras.size());
	}
	
	private Obra generateObra(Construtora construtora) {
		Obra obra = new Obra();
		obra.setConstrutora(construtora);
		obra.setNomeObra("Obra Test");
		obra.setDataInicio(new Date());
		return obra;
	}

}
