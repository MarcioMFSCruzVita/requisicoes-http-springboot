package br.com.cruzvita.requisicoes.fixacao.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/requisicao")
public class RequisicaoController {
	
	@GetMapping("/soma")
	public String requisicaoSoma(@RequestParam int n1, @RequestParam int n2) {
		int resultado = n1+n2;
		return "Resultado da soma: " + resultado;
	}
}
