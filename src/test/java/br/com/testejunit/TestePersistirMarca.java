package br.com.testejunit;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.jpa.EntityManagerUtil;
import br.com.modelo.Marca;


public class TestePersistirMarca {

	EntityManager em;
	
	public TestePersistirMarca() {
		
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
			Marca marca =new Marca();
			marca.setNome("SONY");
			
			em.getTransaction().begin();
			em.persist(marca);
			em.getTransaction().commit();
			em.close();
		   }catch (Exception e) { 
			exception = true;
			e.printStackTrace();
		}
		Assert.assertEquals(false, exception);
		
	}

}
