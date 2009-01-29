package br.anime.dominio;

public class Autor {
	private String nome;
	private String username;
	private String senha;
	
	public Autor(String nome, String username, String senha) {
		this.nome = nome;
		this.username = username;
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
