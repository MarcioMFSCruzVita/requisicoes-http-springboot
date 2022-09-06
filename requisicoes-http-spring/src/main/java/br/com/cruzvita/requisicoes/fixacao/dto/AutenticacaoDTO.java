package br.com.cruzvita.requisicoes.fixacao.dto;

public class AutenticacaoDTO {
	private String email;
	private String senha;
	public Boolean autenticado;
	private byte[] senhaCriptografada;
	private String senhaDecriptografada;
	
	public String getSenhaDecriptografada() {
		return senhaDecriptografada;
	}
	public void setSenhaDecriptografada(String senhaDecriptografada) {
		this.senhaDecriptografada = senhaDecriptografada;
	}
	public byte[] getSenhaCriptografada() {
		return senhaCriptografada;
	}
	public void setSenhaCriptografada(byte[] senhaCriptografada) {
		this.senhaCriptografada = senhaCriptografada;
	}
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
	
	public String toString() {
		if(autenticado == true) {
			return "\nemail:" + email + "\nsenha:" + senhaCriptografada + "\nsenha decript: " + senhaDecriptografada;
		}else {
			return "\nemail:" + email + "\n" + "senha:" + senha;
		}
		
	}
}
