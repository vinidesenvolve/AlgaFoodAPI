package com.algaworks.algafoodapi.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.algaworks.algafoodapi.domain.model.Cozinha;

import org.springframework.stereotype.Component;

@Component
public class CozinhaCRUD {
    
    @PersistenceContext
    public EntityManager em;

    public List<Cozinha> listar() {
        return em.createQuery("from Cozinha", Cozinha.class).getResultList();
    }
}
