package com.algaworks.algafoodapi.jpa;

import java.util.List;

import com.algaworks.algafoodapi.AlgafoodapiApplication;
import com.algaworks.algafoodapi.domain.model.Cozinha;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class CozinhaMain {
    
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodapiApplication.class)
            .web(WebApplicationType.NONE).run(args);

        CozinhaCRUD cozinhaCRUD = applicationContext.getBean(CozinhaCRUD.class);

        // ADD
        Cozinha cozinha1 = new Cozinha();
        
        cozinha1.setNome("Brasileira");
        cozinhaCRUD.salvar(cozinha1);

        // FIND ALL
        List<Cozinha> cozinhas = cozinhaCRUD.listar();
        for(Cozinha cozinha : cozinhas){
            System.out.println(cozinha.getNome());
        }

        // FIND BY ID
        System.out.println(cozinhaCRUD.buscarPorId(1L).getNome());
    
        // UPDATE
        Cozinha cozinhaNova = new Cozinha();

        cozinhaNova.setId(1L);
        cozinhaNova.setNome("Inglesa");
        cozinhaCRUD.salvar(cozinhaNova);

        System.out.println(cozinhaCRUD.buscarPorId(1L).getNome());

        // DELETE
        cozinhaCRUD.remover(cozinhaNova);

        // FIND ALL STREAM API
        List<Cozinha> cozinhasAtualizadas = cozinhaCRUD.listar();
        cozinhasAtualizadas.stream()
            .forEach(cozinha -> System.out.println(cozinha.getNome()));

        }
        
}
