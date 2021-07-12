package br.com.alura.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.resource.spi.work.SecurityContext;

import br.com.alura.model.Ordem;
import br.com.alura.model.Usuario;
import br.com.alura.repository.OrdemRepository;

@ApplicationScoped
public class OrdemService {

	@Inject
	OrdemRepository ordemRepository;
	
	public void inserir(SecurityContext securityContext, Ordem ordem) {
		
		Optional<Usuario> usuarioOptional =
		Usuario.findByIdOptional(ordem.getUserId());
		Usuario usuario = usuarioOptional.orElseThrow();
		if(!usuario.getNome().equals(securityContext.getName())) {
			throw new RuntimeException("Usuario Invalido !");
		}
		ordem.setData(LocalDate.now());
		ordem.setStatus("ENVIADA");
		ordemRepository.persist(ordem);
	}

	public List<Ordem> listar() {
		return ordemRepository.listAll();
	}
}
