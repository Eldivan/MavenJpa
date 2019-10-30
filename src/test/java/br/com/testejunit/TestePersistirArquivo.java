package br.com.testejunit;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.jpa.EntityManagerUtil;
import br.com.modelo.Foto;
import br.com.modelo.Produto;

public class TestePersistirArquivo {

	EntityManager em;
	
	public TestePersistirArquivo() {
		
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
			
			Produto produto = em.find(br.com.modelo.Produto.class , 7);
			Foto foto = new Foto();
			foto.setNome("Impressora");
			foto.setDescricao("foto do produto");
			
			Path path = Paths.get("/home/eldivan/Documentos/Imagens/java 3D.jpg");
			foto.setArquivo(Files.readAllBytes(path));
			produto.adicionarFoto(foto);
			
			em.getTransaction().begin();
			em.persist(produto);
			em.getTransaction().commit();
		
		   }catch (Exception e) { 
			exception = true;
			e.printStackTrace();
		}
		Assert.assertEquals(false, exception);
		
	}

}
