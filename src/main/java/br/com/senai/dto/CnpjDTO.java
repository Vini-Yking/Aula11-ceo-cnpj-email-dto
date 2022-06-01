package br.com.senai.dto;

import br.com.senai.model.Cnpj;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CnpjDTO {
	
	private String cnpj;
	private String nome;
	private String email;
	private String tipo;
	public CnpjDTO(Cnpj cnpj) {
		super();
		this.cnpj = cnpj.getCnpj();
		this.nome = cnpj.getNome();;
		this.email = cnpj.getEmail();;
		this.tipo = cnpj.getTipo();;
	}
	
	
}
