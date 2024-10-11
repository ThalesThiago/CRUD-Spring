package org.sebastiandev.crudspring.controller;

import org.sebastiandev.crudspring.model.Atividade;
import org.sebastiandev.crudspring.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @PostMapping("/{professorId}/cursos/{cursoId}/atividades")
    public Atividade criarAtividade(@PathVariable Long professorId, @PathVariable Long cursoId, @RequestBody Atividade atividade) {
        return professorService.criarAtividade(professorId, cursoId, atividade);
    }

    @PostMapping("/atividades/{atividadeId}/alunos/{alunoId}")
    public Atividade atribuirAtividade(@PathVariable Long atividadeId, @PathVariable Long alunoId) {
        return professorService.atribuirAtividade(atividadeId, alunoId);
    }

    @DeleteMapping("/atividades/{atividadeId}")
    public void deletarAtividade(@PathVariable Long atividadeId) {
        professorService.deletarAtividade(atividadeId);
    }

    @PostMapping("/atividades/{atividadeId}/nota")
    public Atividade adicionarNota(@PathVariable Long atividadeId, @RequestParam Double nota) {
        return professorService.adicionarNota(atividadeId, nota);
    }
}