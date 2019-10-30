package br.com.testejunit;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.jpa.EntityManagerUtil;
import br.com.modelo.Cidade;
import br.com.modelo.Endereco;
import br.com.modelo.PessoaFisica;
import br.com.modelo.TipoEndereco;


public class TestePersistirEndereco {

	EntityManager em;
	
	public TestePersistirEndereco() {
		
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
			Endereco endereco = new Endereco();
			endereco.setNickname("Vini");
			endereco.setEndereco("SQS");
			endereco.setComplemento("Bloco G");
			endereco.setNumero("606");
			endereco.setBairro("ASA SUL");
			endereco.setReferencia("Cidade centro");
			endereco.setCep("70000-000");
			endereco.setTipoEndereco(em.find(TipoEndereco.class, 1));
			endereco.setCidade(em.find(Cidade.class, 1));
			pessoaFisica.adicionarEndereco(endereco);
			
			em.getTransaction().begin();
			em.persist(endereco);
			em.getTransaction().commit();
			em.close();
		   }catch (Exception e) { 
			exception = true;
			e.printStackTrace();
		}
		Assert.assertEquals(false, exception);
		
	}

}
