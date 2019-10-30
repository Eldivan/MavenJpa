package br.com.testejunit;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.jpa.EntityManagerUtil;
import br.com.modelo.Cidade;
import br.com.modelo.Estado;


public class TesteListarCidade {

	EntityManager em;
	
	public TesteListarCidade() {
		
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
			
			String jpql = "from Cidade order by nome";
			List<Cidade> lista = em.createQuery(jpql).getResultList();
			for (Cidade cidade : lista) {
				System.out.println("ID "+ cidade.getId()+ " Nome cidade "+cidade.getNome()+ " Estado "+cidade.getEstado());
			}
			
		   }catch (Exception e) { 
			exception = true;
			e.printStackTrace();
		}
		Assert.assertEquals(false, exception);
		
	}

}
