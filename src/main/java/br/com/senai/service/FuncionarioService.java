package br.com.senai.service;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.senai.dto.FuncionarioDTO;
import br.com.senai.model.Funcionario;
import br.com.senai.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private FotoService fotoService;

	public List<FuncionarioDTO> listar() {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		List<FuncionarioDTO> funcionariosDTO = new ArrayList<>();
		for (Funcionario funcionario : funcionarios) { // isso da pra fazer com map fazer depois
			funcionariosDTO.add(inserirURI(funcionario));

		}
		return funcionariosDTO;
	}

	// metodo para adicionar o link e retornar o funcionarioDTO
	public FuncionarioDTO inserirURI(Funcionario funcionario) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/funcionarios/{id}/foto")
				.buildAndExpand(funcionario.getId()).toUri(); // adicionar na resposta no corpo a URI
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		funcionarioDTO.setNome(funcionario.getNome());
		funcionarioDTO.setUrl(uri.toString());
		return funcionarioDTO;
	}

	public FuncionarioDTO buscar(Long id) {// buscar um funcionario pelo Optional dele
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return inserirURI(funcionario.get());// Ooptional sempre usar o .get() para trazer o Optional
	}
	
	//metodo que salva a foto e o funcionario passando ja funcionario e a foto
	public FuncionarioDTO inserir(Funcionario funcionario, MultipartFile file) throws IOException {
		fotoService.inserir(funcionarioRepository.save(funcionario), file);
		//no foto service ja retorna um funcionario então ele salva no banco ja o funcionario e como esse ja retorna o funcionario ja serve como argumento para o metodo
		return inserirURI(funcionario);
	}
}