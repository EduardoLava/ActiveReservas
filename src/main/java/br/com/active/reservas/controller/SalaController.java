package br.com.active.reservas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.active.reservas.servicos.ServicoSala;

@Controller
@RequestMapping("/salas")
public class SalaController {

	@Autowired
	private ServicoSala servicoSala;
	
	@GetMapping("")
	public String listar() {
		
//		servicoSala.findAll();
		
		return "listaSalas";
		
	}
	
}
