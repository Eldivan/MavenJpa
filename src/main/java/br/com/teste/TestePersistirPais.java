package br.com.teste;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.jpa.EntityManagerUtil;
import br.com.modelo.Pais;

public class TestePersistirPais {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		Pais pais = new Pais();
		pais.setNome("Colombia");
		pais.setIso("COL");
		
		em.getTransaction().begin();
		em.persist(pais);
		em.getTransaction().commit();
		em.close();
		
	}
}
