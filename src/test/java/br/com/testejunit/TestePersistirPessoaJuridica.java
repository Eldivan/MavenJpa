package br.com.testejunit;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.jpa.EntityManagerUtil;
import br.com.modelo.PessoaFisica;
import br.com.modelo.PessoaJuridica;

public class TestePersistirPessoaJuridica {

	EntityManager em;
	
	public TestePersistirPessoaJuridica() {
		
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
			
			PessoaJuridica pessoaJuridica = new PessoaJuridica();
			pessoaJuridica.setNome("Extreme");
			pessoaJuridica.setEmail("extreme@extreme");
			pessoaJuridica.setEmail("SQN");
			pessoaJuridica.setIe("663.193.024.281");
			pessoaJuridica.setCnpj("68.713.275/0001-06");
			pessoaJuridica.setTelefone("3332-2111");
			
			em.getTransaction().begin();
			em.persist(pessoaJuridica);
			em.getTransaction().commit();
			
		   }catch (Exception e) { 
			exception = true;
			e.printStackTrace();
		}
		Assert.assertEquals(false, exception);
		
	}

}
