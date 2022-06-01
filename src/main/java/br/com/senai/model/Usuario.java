package br.com.senai.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;
	private String nome;
	private String email;
	private String senha;
	@OneToMany(mappedBy= "id.usuario", fetch = FetchType.EAGER)
	private Set<UsuarioPerfil> usuarioPerfis = new HashSet<>();
	@ManyToOne
	@JoinColumn(name="id_endereco")
	private Endereco endereco;
	@Override
	public String toString() {
		return "Usuario [Codigo=" + id + ", \nNome=" + nome + ", \nEmail=" + email + "]";
	}
	
	
}
