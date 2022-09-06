package br.com.cruzvita.requisicoes.fixacao.controller;

import org.springframework.web.bind.annotation.*;

import br.com.cruzvita.requisicoes.fixacao.dto.AutenticacaoDTO;

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;

@RestController
@RequestMapping("/requisicao")
public class RequisicaoController {

	static String IV = "AAAAAAAAAAAAAAAA";
	static String textopuro = "teste texto 12345678\0\0\0";
	static String chaveencriptacao = "0123456789abcdef";

	@GetMapping("/soma")
	public String requisicaoSoma(@RequestParam int n1, @RequestParam int n2) {
		int resultado = n1 + n2;
		return "Resultado da soma: " + resultado;
	}

	@PostMapping("/login")
	public String atenticacao(@RequestBody AutenticacaoDTO login) throws Exception {
		String senhaDecript = null;
		String erro;
		login.autenticado = false;

		if (login.getEmail() != null && login.getSenha() != null && login.getSenha().length() >= 8
				&& login.getEmail().contains("@")) {
			login.autenticado = true;

			login.setSenhaCriptografada(encrypt(login.getSenha(), chaveencriptacao));

			senhaDecript = decrypt(login.getSenhaCriptografada(), chaveencriptacao);
			login.setSenhaDecriptografada(senhaDecript);

		} else {
			login.autenticado = false;

		}

		if (login.autenticado == true) {

			return "Você está logado" + "\n" + login;

		} else {
			erro = (login.getSenha() == null) ? "senha invalida menor que 8" : "email invalido";
			return "Dados errados." + "\n" + erro + "\n" + login;
		}
	}

	public static byte[] encrypt(String textopuro, String chaveencriptacao) throws Exception {
		Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
		encripta.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
		return encripta.doFinal(textopuro.getBytes("UTF-8"));
	}

	public static String decrypt(byte[] textoencriptado, String chaveencriptacao) throws Exception {
		Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
		decripta.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
		return new String(decripta.doFinal(textoencriptado), "UTF-8");
	}
}
