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


public class TestePersistirPermissao {

	EntityManager em;
	
	public TestePersistirPermissao() {
		
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
			Permissao permissao = new Permissao();
			permissao.setNome("Administrador");
			permissao.setDescricao("Administrador do sistema");
			 
			Permissao permissao2 = new Permissao();
			permissao2.setNome("Usuario");
			permissao2.setDescricao("usuario do sistema");
			
			em.getTransaction().begin();
			em.persist(permissao);
			em.persist(permissao2);
			em.getTransaction().commit();
			em.close();
		   }catch (Exception e) { 
			exception = true;
			e.printStackTrace();
		}
		Assert.assertEquals(false, exception);
		
	}

}
