package org.sebastiandev.crudspring.controller;

import org.sebastiandev.crudspring.model.Atividade;
import org.sebastiandev.crudspring.model.Curso;
import org.sebastiandev.crudspring.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping("/{alunoId}/cursos")
    public List<Curso> verCursosDoAluno(@PathVariable Long alunoId) {
        return alunoService.verCursosDoAluno(alunoId);
    }


    @GetMapping("/{alunoId}/atividades")
    public List<Atividade> verAtividades(@PathVariable Long alunoId) {
        return alunoService.verAtividades(alunoId);
    }
}