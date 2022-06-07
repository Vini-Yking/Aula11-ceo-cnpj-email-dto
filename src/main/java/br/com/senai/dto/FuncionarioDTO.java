package br.com.senai.dto;

public class FuncionarioDTO {
	
	private String nome;
	private String url;

	public FuncionarioDTO() {
	
	}
	public FuncionarioDTO(String nome, String url) {
		super();
		this.nome = nome;
		this.url = url;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNome() {
		return nome;
	}
	public String getUrl() {
		return url;
	}
	
}
