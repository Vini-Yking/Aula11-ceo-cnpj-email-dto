package br.com.senai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Foto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_foto")
	private Long id;
	
	//tipo de foto precisa ser notation lob e o typo cadeia de bytes = binario
	@Lob
	private byte[] dados;
	
	private String tipo;
	private String nome;
	
	
	//preicisa mapear a coluna com ID que ela será relacionada
	@OneToOne
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;


	public Foto(byte[] dados, String tipo, String nome, Funcionario funcionario) {
		this.dados = dados;
		this.tipo = tipo;
		this.nome = nome;
		this.funcionario = funcionario;
	}

	public Foto() {
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public byte[] getDados() {
		return dados;
	}


	public void setDados(byte[] dados) {
		this.dados = dados;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
