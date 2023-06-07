package com.notas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

