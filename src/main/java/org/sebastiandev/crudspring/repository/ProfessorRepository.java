package org.sebastiandev.crudspring.repository;

import org.sebastiandev.crudspring.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
