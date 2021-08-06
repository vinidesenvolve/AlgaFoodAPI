package com.algaworks.algafoodapi.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.algaworks.algafoodapi.domain.model.Cozinha;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CozinhaCRUD {
    
    @PersistenceContext
    public EntityManager em;

    @Transactional
    public Cozinha salvar(Cozinha cozinha) {
        return em.merge(cozinha);
    }

    public List<Cozinha> listar() {
        return em.createQuery("from Cozinha", Cozinha.class).getResultList();
    }

    public Cozinha buscarPorId(Long id) {
        return em.find(Cozinha.class, id);
    }

    @Transactional
    public void remover(Cozinha cozinha) {
        cozinha = buscarPorId(cozinha.getId());
        em.remove(cozinha);
    }
}
