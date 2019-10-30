package br.com.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.modelo.Pais;

public class TesteAlterarPais {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MavenJpa-pu");
		EntityManager em = emf.createEntityManager();
		
		Pais pais = em.find(Pais.class, 14);
		pais.setNome("Argentina");
		pais.setIso("ARG");
		
		em.getTransaction().begin();
		em.merge(pais);
		em.getTransaction().commit();
		em.close();
		emf.close();	
	}

}
