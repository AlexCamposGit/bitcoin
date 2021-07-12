package br.com.alura.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.alura.model.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

//Instancia para todo projeto
@ApplicationScoped
public class OrdemRepository implements PanacheRepository<Ordem> {
	
}
