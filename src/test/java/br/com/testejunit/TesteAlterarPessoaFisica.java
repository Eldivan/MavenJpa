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

public class TesteAlterarPessoaFisica {

	EntityManager em;
	
	public TesteAlterarPessoaFisica() {
		
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
			PessoaFisica pessoaFisica = em.find(PessoaFisica.class, 1);
			pessoaFisica.setCpf("45933470-74");
			pessoaFisica.setNascimento(Calendar.getInstance());
			pessoaFisica.setNomeUsuario("Usuario");
			pessoaFisica.setRg("123456789");
			pessoaFisica.setSenha("123456");
			pessoaFisica.setEmail("email@email.com");
			pessoaFisica.setNome("Marcus");
			pessoaFisica.setTelefone("9999-8888");
			
			em.getTransaction().begin();
			em.merge(pessoaFisica);
			em.getTransaction().commit();
			em.close();
		   }catch (Exception e) { 
			exception = true;
			e.printStackTrace();
		}
		Assert.assertEquals(false, exception);
		
	}

}
