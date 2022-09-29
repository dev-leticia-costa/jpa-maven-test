package org.example;

import org.example.empiricus.MinhaEntidade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TesteJPA {
    public static void main(String[] args) {
        //EntityManagerFactory --> é um gerenciador de configurações das entidades
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();
        List<MinhaEntidade> lista = em.createQuery("FROM MinhaEntidade", MinhaEntidade.class).getResultList();


    MinhaEntidade objeto = new MinhaEntidade();
    objeto.setNumber(456454545);
    objeto.setText("Meu texto");

    //persistir tudo no namco
    em.getTransaction().begin();
    em.persist(objeto);
    em.getTransaction().commit();

    em.close();
    emf.close();

    }
     }
