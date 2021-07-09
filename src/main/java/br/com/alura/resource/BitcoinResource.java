package br.com.alura.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.alura.model.Bitcoin;
import br.com.alura.service.BitcoinService;

//Classe responsavel pelo controle de interface de requisicao externa

@Path("/bitcoins")
public class BitcoinResource {

//Injeta o objeto da interface BitcoinService 
//Rest cliente registra o objeto para ser injetado em outra classe 
	
	@Inject
	@RestClient
	BitcoinService bitcoinService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bitcoin> listar(){
		return bitcoinService.listar();
	}

}

