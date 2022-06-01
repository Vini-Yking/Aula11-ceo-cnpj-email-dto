package br.com.senai.dto;

import java.util.HashSet;
import java.util.Set;

import br.com.senai.model.Usuario;
import br.com.senai.model.UsuarioPerfil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioInserirDTO {

	private String nome;
	private String email;
	private String senha;
	private Set<UsuarioPerfil>usuarioPerfis = new HashSet<>();
	public UsuarioInserirDTO(Usuario usuario) {
		
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}
	
}
