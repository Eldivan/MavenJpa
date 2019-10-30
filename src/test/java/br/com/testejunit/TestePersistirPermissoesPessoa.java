package br.com.testejunit;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.jpa.EntityManagerUtil;
import br.com.modelo.Permissao;
import br.com.modelo.PessoaFisica;


public class TestePersistirPermissoesPessoa {

	EntityManager em;
	
	public TestePersistirPermissoesPessoa() {
		
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		em = EntityManagerUtil.getEntityManager();
	}

	@After
	public void tearDown() throws Exception {
		em.close();
	}

	@Test
	public void test() {
		boolean exception = false;
		try {
			PessoaFisica pessoaFisica = em.find(PessoaFisica.class, 2);
			
			Permissao permissao = em.find(Permissao.class, "Administrador");
			Permissao permissao2 = em.find(Permissao.class, "Usuario");
			 
			pessoaFisica.getListaPermissoes().add(permissao);
			pessoaFisica.getListaPermissoes().add(permissao2);
		
			
			em.getTransaction().begin();
			em.persist(pessoaFisica);
			em.getTransaction().commit();
			
		   }catch (Exception e) { 
			exception = true;
			e.printStackTrace();
		}
		Assert.assertEquals(false, exception);
		
	}

}
