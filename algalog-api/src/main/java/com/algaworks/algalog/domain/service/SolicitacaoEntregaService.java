package com.algaworks.algalog.domain.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.repository.ClienteRepository;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.StatusEntrega;


@Service
public class SolicitacaoEntregaService {
	
	private CatalogoClienteService catalogoClienteService;
	private EntregaRepository entregaRepository;
	
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		
		Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		entrega.setCliente(cliente);
		 
		return entregaRepository.save(entrega);
	}


	

	

	public SolicitacaoEntregaService(CatalogoClienteService catalogoClienteService, EntregaRepository entregaRepository) {
		super();
		this.catalogoClienteService = catalogoClienteService;
		this.entregaRepository = entregaRepository;
	}
 

	public EntregaRepository getEntregaRepository() {
		return entregaRepository;
	}


	public void setEntregaRepository(EntregaRepository entregaRepository) {
		this.entregaRepository = entregaRepository;
	}
	
	
	
}
