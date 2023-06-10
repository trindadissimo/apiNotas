package com.notas.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cadastro {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(mappedBy = "cadastro")
    private Usuario usuario;

    @OneToMany(mappedBy = "cadastro")
    private List<Tarefa> tarefas;

    @ManyToMany
    @JoinTable(name = "cadastro_checklist",
            joinColumns = @JoinColumn(name = "cadastro_id"),
            inverseJoinColumns = @JoinColumn(name = "checklist_id"))
    private List<Checklist> checklists;

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

}

