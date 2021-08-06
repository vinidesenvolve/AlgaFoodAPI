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

        Cozinha cozinha1 = new Cozinha();
        cozinha1.setNome("Brasileira");

        cozinhaCRUD.adicionar(cozinha1);

        List<Cozinha> cozinhas = cozinhaCRUD.listar();

        for(Cozinha cozinha : cozinhas){
            System.out.println(cozinha.getNome());
        }

    }
}
