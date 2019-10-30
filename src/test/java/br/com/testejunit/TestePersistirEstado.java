package br.com.testejunit;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.jpa.EntityManagerUtil;
import br.com.modelo.Estado;
import br.com.modelo.Pais;

public class TestePersistirEstado {

	EntityManager em;
	
	public TestePersistirEstado() {
		
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
			Estado estado = new Estado();
			estado.setNome("Bahia");
			estado.setUf("BA");
			estado.setPais(em.find(Pais.class, 13));
			
			em.getTransaction().begin();
			em.persist(estado);
			em.getTransaction().commit();
			
		   }catch (Exception e) { 
			exception = true;
			e.printStackTrace();
		}
		Assert.assertEquals(false, exception);
		
	}

}
