package br.com.senai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.model.Cnpj;

public interface CnpjRepository extends JpaRepository<Cnpj, Long>{

	Optional<Cnpj> findByCnpj(String cnpj);
}
