package br.com.senai.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.senai.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
	
	/**
	 * JPQL
	 * 
	 */
	@Query("SELECT v FROM Vendedor v WHERE v.salario>=:valorMinimo and v.salario <=:valorMaximo")
	Page<Vendedor> buscarSalarioPorFaixa(Double valorMinimo, Double valorMaximo, Pageable pageable);
	
	/**
	 * usar o between
	 */
	Page<Vendedor> findBySalarioBetween(Double valorMinimo, Double valorMaximo, Pageable pageable);
	
	@Query("SELECT v FROM Vendedor v WHERE UPPER(v.nome) LIKE upper(CONCAT('%',:paramNome, '%'))")
	Page<Vendedor> buscarPorNome(String paramNome, Pageable pageable);

	/**
	usar o like ignorando case
	 */
	Page<Vendedor> findByNomeContainingIgnoreCase (String paramNome, Pageable pageable);
	
	/**
	 * Usar data de nascimento maior que
	 */
	Page<Vendedor> findByDataNascimentoGreaterThan(LocalDate dataNascimento, Pageable pageable);
}
