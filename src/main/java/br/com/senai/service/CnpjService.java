package br.com.senai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.senai.dto.CnpjDTO;
import br.com.senai.model.Cnpj;
import br.com.senai.model.Endereco;
import br.com.senai.repository.CnpjRepository;

@Service
public class CnpjService {

	@Autowired
	private CnpjRepository cnpjRepository;

	public CnpjDTO buscar(String cnpj) {
		Optional<Cnpj> cnpjOpt = cnpjRepository.findByCnpj(cnpj);

		if (cnpjOpt.isPresent()) {
			return new CnpjDTO(cnpjOpt.get());
		} else {
			RestTemplate rs = new RestTemplate();
			String url = "https://receitaws.com.br/v1/cnpj/" + cnpj;
			Optional<Cnpj> cnpjViaCnpj = Optional.ofNullable(rs.getForObject(url, Cnpj.class));
			if (!cnpjViaCnpj.get().getCnpj().isEmpty()) {	//regex [^a-zA-Z0-9]",""
				String cnpjSemTraco = cnpjViaCnpj.get().getCnpj().replaceAll("[^0-9]", "");
				cnpjViaCnpj.get().setCnpj(cnpjSemTraco);
				return inserir(cnpjViaCnpj.get());
			} else {
				return null;
			}
		}

	}
	
	private CnpjDTO inserir(Cnpj cnpj) {
		cnpj = cnpjRepository.save(cnpj);
		return new CnpjDTO(cnpj);
	}
}
