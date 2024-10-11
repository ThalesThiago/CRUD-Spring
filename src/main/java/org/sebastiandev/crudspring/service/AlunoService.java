package org.sebastiandev.crudspring.service;

import org.sebastiandev.crudspring.model.Aluno;
import org.sebastiandev.crudspring.model.Curso;
import org.sebastiandev.crudspring.model.Atividade;
import org.sebastiandev.crudspring.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Curso> verCursosDoAluno(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        return aluno.getCursos();
    }

    public List<Atividade> verAtividades(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        return aluno.getAtividades();
    }

    //CRUD methods
    public Aluno getAluno(Long alunoId) {
        return alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }
    public Aluno createAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
    public Aluno updateAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
    public void deleteAluno(Long alunoId) {
        alunoRepository.deleteById(alunoId);
    }
    public List<Aluno> getAlunos() {
        return alunoRepository.findAll();
    }
}
