package br.com.teste;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import br.com.jpa.EntityManagerUtil;
import br.com.modelo.Pais;

public class TesteValidarPais {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerUtil.getEntityManager();
		
		Pais pais = new Pais();
		//pais.setNome("Paraguai");
		//pais.setIso("PAR");
		
		em.getTransaction().begin();
		Validator validador=Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Pais>> erros = validador.validate(pais);
		if(erros.size() > 0) {
			for(ConstraintViolation<Pais> erro : erros)	{
				System.out.println("Erro "+erro.getMessage());
			 }
		}else {	
			em.persist(pais);		
		}
		
		em.getTransaction().commit();
		em.close();
		
	 }
		
}

