package br.com.senai.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "usuario_perfil")

public class UsuarioPerfil {
	@EmbeddedId
	private UsuarioPerfilPK id = new UsuarioPerfilPK();

	@Column(name = "data_criacao")
	private LocalDate dataCriacao;

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public void setUsuario(Usuario usuario) {
		id.setUsuario(usuario);
	}
	public void setPerfil(Perfil perfil) {
		id.setPerfil(perfil);
	}
	
	public Perfil getPerfil() {
		return id.getPerfil();
	}
	public Usuario getUsuario() {
		return id.getUsuario();
	}
}
