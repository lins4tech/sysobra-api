package com.lins4tech.sysobras.api.repositories;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.lins4tech.sysobras.api.entities.Construtora;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ConstrutoraRepositoryTest {
	
	@Autowired
	private ConstrutoraRepository construtoraRepository;
	
	@Before
	public void setUp() throws Exception {
		Construtora construtora = new Construtora();
		construtora.setRazaoSocial("Construtora Exemplo");
		construtora.setCnpj("15009078000188");
		this.construtoraRepository.save(construtora);
	}
	
	@After
	public final void tearDown() {
		this.construtoraRepository.deleteAll();
	}
	
	@Test
	public void testFindByCnpj() {
		Construtora construtora = this.construtoraRepository.findByCnpj("15009078000188");
		assertNotNull("Construtora is null", construtora);
		
	}
	
}
