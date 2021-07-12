package br.com.alura.resource;

import java.time.LocalDate;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.resource.spi.work.SecurityContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

import br.com.alura.model.Ordem;
import br.com.alura.repository.OrdemRepository;
import br.com.alura.service.OrdemService;

@Path("/ordens")
public class OrdemResource {

	@Inject
	OrdemService ordemService;
	
	@POST
	@Transactional
	@RolesAllowed("user")
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(@Context SecurityContext securityContext ,Ordem ordem) {
		ordemService.inserir(securityContext, ordem);
	}
	
	@GET
	@RolesAllowed("admin")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ordem> listar(){
		return ordemService.listar();
	}
}
