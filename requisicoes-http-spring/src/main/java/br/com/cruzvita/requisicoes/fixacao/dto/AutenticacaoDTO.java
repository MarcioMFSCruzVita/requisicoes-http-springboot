package br.com.cruzvita.requisicoes.fixacao.dto;

public class AutenticacaoDTO {
	private String email;
	private String senha;
	public Boolean autenticado;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
