package br.com.senai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.dto.CnpjDTO;
import br.com.senai.service.CnpjService;

@RestController
@RequestMapping("/api/cnpj")
public class CnpjController {

	@Autowired
	private CnpjService cnpjService;

	@GetMapping("{cnpj}")
	public ResponseEntity<CnpjDTO> buscar(@PathVariable String cnpj) {
		CnpjDTO cnpjDTO = cnpjService.buscar(cnpj);
		return cnpjDTO == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(cnpjDTO);
	}

}
