package com.notas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.controller.NotFoundEntityException;
import com.notas.model.Cadastro;
import com.notas.repository.CadastroRepository;

import java.util.List;

@Service
public class CadastroService {

    private final CadastroRepository cadastroRepository;

    @Autowired
    public CadastroService(CadastroRepository cadastroRepository) {
        this.cadastroRepository = cadastroRepository;
    }

    public Cadastro createCadastro(Cadastro cadastro) {
         return cadastroRepository.save(cadastro);
    }

    public List<Cadastro> getAllCadastros() {
        return cadastroRepository.findAll();
    }
    
    public Cadastro getCadastroById(Long id) throws NotFoundEntityException {
		return cadastroRepository.findById(id).orElseThrow(() -> 
		new NotFoundEntityException("Cadastro não encontrado"));
	}
    
	public Cadastro createPlaylist(Cadastro cadastro) {
		return cadastroRepository.save(cadastro);
	}

	public Object updateCadastro(String name, Cadastro cadastro) {
		Cadastro existingCadastro = cadastroRepository.findById(name);	
		existingCadastro.setname(cadastro.getname());
		
		return cadastroRepository.save(existingCadastro);
	}
}

