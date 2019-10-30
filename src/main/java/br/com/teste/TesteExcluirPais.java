package br.com.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.modelo.Pais;

public class TesteExcluirPais {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MavenJpa-pu");
		EntityManager em = emf.createEntityManager();
		
		Pais pais =em.find(Pais.class,17	);
		em.getTransaction().begin();
		em.remove(pais);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}

}
