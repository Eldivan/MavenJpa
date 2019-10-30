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
import br.com.modelo.Produto;
import br.com.modelo.Venda;
import br.com.modelo.VendaItens;

public class TestePersistirVenda {

	EntityManager em;
	
	public TestePersistirVenda() {
		
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
			
			Produto produto = em.find(Produto.class, 6);
			PessoaFisica pessoaFisica = em.find(PessoaFisica.class, 4);
			Venda venda = new Venda();
			venda.setData(Calendar.getInstance());
			venda.setParcelas(3);
			venda.setPessoaFisica(pessoaFisica);
			
			VendaItens vendaItens = new VendaItens();
			
			vendaItens.setProduto(produto);
			vendaItens.setQuantidade(2);
			vendaItens.setValorUnitario(produto.getPreco());
			vendaItens.setValorTotal( vendaItens.getQuantidade() * vendaItens.getValorUnitario());
			
			venda.adicionarItens(vendaItens);
			
			em.getTransaction().begin();
			em.persist(venda);
			em.persist(produto);
			em.getTransaction().commit();
			
		   }catch (Exception e) { 
			exception = true;
			e.printStackTrace();
		}
		Assert.assertEquals(false, exception);
		
	}

}
