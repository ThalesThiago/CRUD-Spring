package org.sebastiandev.crudspring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @ManyToOne
    @JsonIgnoreProperties({"atividades", "cursos", "professor", "alunos"})
    private Curso curso;

    @ManyToOne
    @JsonIgnoreProperties({"atividades", "cursos"})
    private Professor professor;

    @ManyToMany
    @JsonIgnoreProperties({"atividades", "cursos"})
    private List<Aluno> alunos;

    @OneToMany(mappedBy = "atividade", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("atividade")
    private List<Nota> notas = new ArrayList<>();

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public void addNota(Nota nota) {
        notas.add(nota);
        nota.setAtividade(this);
    }

    public void removeNota(Nota nota) {
        notas.remove(nota);
        nota.setAtividade(null);
    }

    public void setNota(Double notaValor) {
        Nota nota = new Nota();
        nota.setValor(notaValor);
        addNota(nota);
    }
}