package org.sebastiandev.crudspring.controller;

import org.sebastiandev.crudspring.model.Aluno;
import org.sebastiandev.crudspring.model.Curso;
import org.sebastiandev.crudspring.model.Professor;
import org.sebastiandev.crudspring.service.AlunoService;
import org.sebastiandev.crudspring.service.CursoService;
import org.sebastiandev.crudspring.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;
    @Autowired
    private ProfessorService professorService;
    @Autowired
    private AlunoService alunoService;

    @PostMapping("/{cursoId}/alunos/{alunoId}")
    public Curso adicionarAlunoAoCurso(@PathVariable Long cursoId, @PathVariable Long alunoId) {
        return cursoService.adicionarAlunoAoCurso(cursoId, alunoId);
    }
    //removerAlunoDoCurso
    @DeleteMapping("/{cursoId}/alunos/{alunoId}")
    public Curso removerAlunoDoCurso(@PathVariable Long cursoId, @PathVariable Long alunoId) {
        return cursoService.removerAlunoDoCurso(cursoId, alunoId);
    }

    @PostMapping("/{cursoId}/professor/{professorId}")
    public Curso atribuirProfessor(@PathVariable Long cursoId, @PathVariable Long professorId) {
        return cursoService.atribuirProfessor(cursoId, professorId);
    }
    //removerProfessorDoCurso
    @DeleteMapping("/{cursoId}/professor")
    public Curso removerProfessorDoCurso(@PathVariable Long cursoId) {
        return cursoService.removerProfessorDoCurso(cursoId);
    }


    //crud de professor
    @GetMapping("/get/professores")
    public Iterable<Professor> getProfessores() {
        return professorService.getProfessores();
    }

    @GetMapping("/get/professor/{professorId}")
    public Professor getProfessor(@PathVariable Long professorId) {
        return professorService.getProfessor(professorId);
    }
    @PostMapping("/create/professor")
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorService.createProfessor(professor);
    }
    @PutMapping("/update/professor")
    public Professor updateProfessor(@RequestBody Professor professor) {
        return professorService.updateProfessor(professor);
    }
    @DeleteMapping("/delete/professor/{professorId}")
    public void deleteProfessor(@PathVariable Long professorId) {
        professorService.deleteProfessor(professorId);
    }

    //crud de aluno
    @GetMapping("/get/alunos")
    public Iterable<Aluno> getAlunos() {
        return alunoService.getAlunos();
    }
    @GetMapping("/get/aluno/{alunoId}")
    public Aluno getAluno(@PathVariable Long alunoId) {
        return alunoService.getAluno(alunoId);
    }
    @PostMapping("/create/aluno")
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoService.createAluno(aluno);
    }
    @PutMapping("/update/aluno")
    public Aluno updateAluno(@RequestBody Aluno aluno) {
        return alunoService.updateAluno(aluno);
    }
    @DeleteMapping("/delete/aluno/{alunoId}")
    public void deleteAluno(@PathVariable Long alunoId) {
        alunoService.deleteAluno(alunoId);
    }


    //crud de curso
    @GetMapping("/get/cursos")
    public Iterable<Curso> getCursos() {
        return cursoService.getCursos();
    }
    @GetMapping("/get/curso/{cursoId}")
    public Curso getCurso(@PathVariable Long cursoId) {
        return cursoService.getCurso(cursoId);
    }
    @PostMapping("/create/curso")
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoService.createCurso(curso);
    }
    @PutMapping("/update/curso")
    public Curso updateCurso(@RequestBody Curso curso) {
        return cursoService.updateCurso(curso);
    }
    @DeleteMapping("/delete/curso/{cursoId}")
    public void deleteCurso(@PathVariable Long cursoId) {
        cursoService.deleteCurso(cursoId);
    }

    // Endpoints para criar, atualizar, deletar e obter
}