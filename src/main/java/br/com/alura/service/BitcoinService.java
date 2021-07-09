package br.com.alura.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.alura.model.Bitcoin;

//Interface reponsavel pela requisicao externa especifica apontada no 
//aplication.properties br.com.alura.service.BitcoinService/mp-rest/url=https://alura-bitcoin.herokuapp.com

@Path("/bitcoins")
@RegisterRestClient
public interface BitcoinService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bitcoin> listar();

}
