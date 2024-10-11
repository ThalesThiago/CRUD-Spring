package org.sebastiandev.crudspring.repository;

import org.sebastiandev.crudspring.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("SELECT a FROM Aluno a JOIN a.cursos c WHERE c.id = :cursoId")
    List<Aluno> findAlunosByCursoId(Long cursoId);
}