package br.com.senai.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.senai.model.Usuario;
import br.com.senai.repository.UsuarioRepository;
import br.com.senai.security.UsuarioDetalhe;
@Service
public class UsuarioDetalheImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	/**
	 * busca pelo usuario
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByNome(username);
			if (usuario.isPresent()) {
				return new UsuarioDetalhe(usuario);
			}
		throw new UsernameNotFoundException("Usuario invalido!,");
	}

}
