package org.sebastiandev.crudspring.service;

import org.sebastiandev.crudspring.model.Aluno;
import org.sebastiandev.crudspring.model.Curso;
import org.sebastiandev.crudspring.model.Professor;
import org.sebastiandev.crudspring.repository.AlunoRepository;
import org.sebastiandev.crudspring.repository.CursoRepository;
import org.sebastiandev.crudspring.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public Curso adicionarAlunoAoCurso(Long cursoId, Long alunoId) {
        // Implementação para adicionar aluno
        //optional para verificar se o curso existe
        Optional<Curso> cursoOptional = cursoRepository.findById(cursoId);
        if (cursoOptional.isEmpty()) {
            throw new RuntimeException("Curso não encontrado");
        }
        Curso curso = cursoOptional.get();
        //optional para verificar se o aluno existe
        Optional<Aluno> alunoOptional = alunoRepository.findById(alunoId);
        if (alunoOptional.isEmpty()) {
            throw new RuntimeException("Aluno não encontrado");
        }
        Aluno aluno = alunoOptional.get();
        //adiciona o aluno ao curso
        curso.getAlunos().add(aluno);

        //adiciona o curso ao aluno
        aluno.getCursos().add(curso);
        alunoRepository.save(aluno);

        return cursoRepository.save(curso);

    }

    public Curso removerAlunoDoCurso(Long cursoId, Long alunoId) {
        // Implementação para remover aluno
        //optional para verificar se o curso existe
        Optional<Curso> cursoOptional = cursoRepository.findById(cursoId);
        if (cursoOptional.isEmpty()) {
            throw new RuntimeException("Curso não encontrado");
        }
        Curso curso = cursoOptional.get();
        //optional para verificar se o aluno existe
        Optional<Aluno> alunoOptional = alunoRepository.findById(alunoId);
        if (alunoOptional.isEmpty()) {
            throw new RuntimeException("Aluno não encontrado");
        }
        Aluno aluno = alunoOptional.get();
        //remove o aluno do curso
        curso.getAlunos().remove(aluno);

        //remove o aluno do curso
        aluno.getCursos().remove(curso);
        alunoRepository.save(aluno);
        return cursoRepository.save(curso);

    }

    public Curso atribuirProfessor(Long cursoId, Long professorId) {
        // Implementação para atribuir professor
        //optional para verificar se o curso existe
        Optional<Curso> cursoOptional = cursoRepository.findById(cursoId);
        if (cursoOptional.isEmpty()) {
            throw new RuntimeException("Curso não encontrado");
        }
        Curso curso = cursoOptional.get();
        //optional para verificar se o professor existe
        Optional<Professor> professorOptional = professorRepository.findById(professorId);
        if (professorOptional.isEmpty()) {
            throw new RuntimeException("Professor não encontrado");
        }
        Professor professor = professorOptional.get();
        //adiciona o professor ao curso
        curso.setProfessor(professor);

        //adiciona o curso ao professor
        professor.getCursos().add(curso);
        professorRepository.save(professor);

        return cursoRepository.save(curso);
    }

    public Curso removerProfessorDoCurso(Long cursoId) {
        // Implementação para remover professor
        //optional para verificar se o curso existe
        Optional<Curso> cursoOptional = cursoRepository.findById(cursoId);
        if (cursoOptional.isEmpty()) {
            throw new RuntimeException("Curso não encontrado");
        }
        Curso curso = cursoOptional.get();
        //optional para verificar se o professor existe
        Optional<Professor> professorOptional = professorRepository.findById(curso.getProfessor().getId());
        if (professorOptional.isEmpty()) {
            throw new RuntimeException("Professor não encontrado");
        }
        Professor professor = professorOptional.get();
        //remove o professor do curso
        curso.setProfessor(null);

        //remove o curso do professor
        professor.getCursos().remove(curso);
        professorRepository.save(professor);

        return cursoRepository.save(curso);
    }

    // CRUD methods
    public Curso getCurso(Long cursoId) {
        return cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }
    public Curso createCurso(Curso curso) {
        return cursoRepository.save(curso);
    }
    public Curso updateCurso(Curso curso) {
        return cursoRepository.save(curso);
    }
    public void deleteCurso(Long cursoId) {
        cursoRepository.deleteById(cursoId);
    }
    public List<Curso> getCursos() {
        return cursoRepository.findAll();
    }
}
