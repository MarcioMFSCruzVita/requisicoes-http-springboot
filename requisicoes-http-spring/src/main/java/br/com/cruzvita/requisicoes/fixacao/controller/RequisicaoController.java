package br.com.cruzvita.requisicoes.fixacao.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requisicao")
public class RequisicaoController {
	
	@GetMapping("/soma?n1={n1}&n2={n2}")
	public String requisicaoSoma(int n1, int n2) {
		return "Resultado da soma: " + n1+n2;
	}
}
