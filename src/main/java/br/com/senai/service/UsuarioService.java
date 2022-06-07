package br.com.senai.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.senai.config.MailConfig;
import br.com.senai.dto.UsuarioDTO;
import br.com.senai.dto.UsuarioInserirDTO;
import br.com.senai.exception.EmailException;
import br.com.senai.model.Usuario;
import br.com.senai.model.UsuarioPerfil;
import br.com.senai.repository.UsuarioPerfilRepository;
import br.com.senai.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private BCryptPasswordEncoder crypto;

	@Autowired
	private PerfilService perfilService;

	@Autowired
	private UsuarioPerfilRepository usuarioPerfilRepository;
	
	@Autowired
	private MailConfig mailConfig;

	public List<UsuarioDTO> listar() {
		List<Usuario> usuarios = usuarioRepository.findAll();

		/*
		 * List<UsuarioDTO> usuariosDTO = new ArrayList<>(); for (Usuario u : usuarios)
		 * { UsuarioDTO usuarioDTO = new UsuarioDTO(u); usuariosDTO.add(usuarioDTO); }
		 * return usuariosDTO;
		 */

		return usuarios.stream().map(u -> new UsuarioDTO(u)).collect(Collectors.toList());
	}

	public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
		return usuarioRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	public UsuarioDTO inserir(UsuarioInserirDTO usuarioInserirDTO) {

		if (usuarioRepository.findByEmail(usuarioInserirDTO.getEmail()) != null) {
			throw new EmailException("Este email ja esta em cadastrado");
		}
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioInserirDTO.getNome());
		usuario.setEmail(usuarioInserirDTO.getEmail());
		usuario.setSenha(crypto.encode(usuarioInserirDTO.getSenha()));
		usuario = usuarioRepository.save(usuario);

		for (UsuarioPerfil usuarioPerfil : usuarioInserirDTO.getUsuarioPerfis()) {
			usuarioPerfil.setUsuario(usuario);
			usuarioPerfil.setDataCriacao(LocalDate.now());
			usuarioPerfil.setPerfil(perfilService.buscar(usuarioPerfil.getPerfil().getId()));
		}
		usuarioPerfilRepository.saveAll(usuarioInserirDTO.getUsuarioPerfis());
		//mailConfig.enviarEmail(usuario.getEmail(), "Confirmação de Cadastro de Usuario", usuario.toString());
		return new UsuarioDTO(usuario);
	}

}
