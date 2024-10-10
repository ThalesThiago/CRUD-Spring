package org.sebastiandev.crudspring.repository;

import org.sebastiandev.crudspring.model.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    @Query("SELECT a FROM Atividade a WHERE a.professor.id = :professorId")
    List<Atividade> findAtividadesByProfessorId(Long professorId);
}