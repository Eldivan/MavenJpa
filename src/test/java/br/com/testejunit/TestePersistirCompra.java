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
import br.com.modelo.Compra;
import br.com.modelo.CompraID;
import br.com.modelo.CompraItem;
import br.com.modelo.PessoaJuridica;
import br.com.modelo.Produto;

public class TestePersistirCompra {

	EntityManager em;
	
	public TestePersistirCompra() {
		
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
		
			Produto produto = em.find(Produto.class, 8);
			PessoaJuridica pessoajuridica = em.find(PessoaJuridica.class, 10);
			Compra obj = new Compra();
			
			CompraID id = new CompraID();
			id.setPessoaJuridica(pessoajuridica);
			id.setNumeroNota(1234);
			
			obj.setId(id);
			obj.setData(Calendar.getInstance());
			
			CompraItem item =new CompraItem();
			item.setProduto(produto);
			item.setValorUnitario(produto.getPreco());
			item.setQuantidade(2);
			item.setValorTotal(item.getQuantidade() * item.getValorUnitario());
			
			obj.adicionarItem(item);
			
			
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
			
		   }catch (Exception e) { 
			exception = true;
			e.printStackTrace();
		}
		Assert.assertEquals(false, exception);
		
	}

}
