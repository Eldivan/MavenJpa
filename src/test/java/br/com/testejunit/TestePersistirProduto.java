package br.com.testejunit;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.jpa.EntityManagerUtil;
import br.com.modelo.Categoria;
import br.com.modelo.Marca;
import br.com.modelo.Produto;

public class TestePersistirProduto {

	EntityManager em;
	
	public TestePersistirProduto() {
		
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
			
			Produto produto = new Produto();
			produto.setNome("Teclado");
			produto.setPreco(50.00);
			produto.setQuantidadeEstoque(10);
			produto.setDescricao("Teclado ergonomico");
			produto.setMarca(em.find(Marca.class, 4));
			produto.setCategoria(em.find(Categoria.class, 1));
			
			em.getTransaction().begin();
			em.persist(produto);
			em.getTransaction().commit();
			em.close();
		   }catch (Exception e) { 
			exception = true;
			e.printStackTrace();
		}
		Assert.assertEquals(false, exception);
		
	}

}
