package org.sebastiandev.crudspring.repository;

import org.sebastiandev.crudspring.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query("SELECT c FROM Curso c WHERE c.professor.id = :professorId")
    List<Curso> findCursosByProfessorId(Long professorId);
}
