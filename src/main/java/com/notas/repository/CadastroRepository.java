package com.notas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notas.model.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
	List<Cadastro> findByNameOrderByDateDesc(String name);
	List<Cadastro> findAll();
	Cadastro findById(String name);
	Cadastro findByName(String name);
	long countByName(String name);
	void deleteByName(String name);
	void deleteById(Long id);
	boolean existsByName(String name);
}

