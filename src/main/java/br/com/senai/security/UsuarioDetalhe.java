package br.com.senai.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.senai.model.Usuario;
import br.com.senai.model.UsuarioPerfil;

public class UsuarioDetalhe implements UserDetails {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private Optional<Usuario> usuario;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		
		for (UsuarioPerfil usuarioPerfil : usuario.get().getUsuarioPerfis()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(usuarioPerfil.getPerfil().getNome()));
		}
		return grantedAuthorities;
	}

	
	public UsuarioDetalhe(Optional<Usuario> usuario) {
		super();
		this.usuario = usuario;
	}


	@Override
	public String getPassword() {
		
		return usuario.get().getSenha();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usuario.get().getNome();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
