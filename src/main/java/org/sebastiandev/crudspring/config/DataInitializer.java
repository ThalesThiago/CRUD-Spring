package org.sebastiandev.crudspring.config;

import org.sebastiandev.crudspring.model.*;
import org.sebastiandev.crudspring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import jakarta.annotation.PostConstruct;
import java.util.Collections;

@Configuration
public class DataInitializer {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private NotaRepository notaRepository;

    @PostConstruct
    public void init() {
        // Create Professor 1
        Professor professor1 = new Professor();
        professor1.setNome("Marcio Bueno");
        professor1 = professorRepository.save(professor1);

        // Create Curso
        Curso curso = new Curso();
        curso.setNome("Sistemas Para Internet");
        curso.setProfessor(professor1);
        curso = cursoRepository.save(curso);

        // Create Aluno 1
        Aluno aluno1 = new Aluno();
        aluno1.setNome("Cauã Sebastian");
        aluno1.setEmail("Test@gmail.com");
        aluno1 = alunoRepository.save(aluno1);

        // Create Aluno 2
        Aluno aluno2 = new Aluno();
        aluno2.setNome("Jonh Doe");
        aluno2.setEmail("jonhdoe@gmail.com");
        aluno2 = alunoRepository.save(aluno2);

        // Create Aluno 3
        Aluno aluno3 = new Aluno();
        aluno3.setNome("Maria");
        aluno3.setEmail("Maria@hotmail.com");
        aluno3 = alunoRepository.save(aluno3);

        // Create Atividade 1
        Atividade atividade1 = new Atividade();
        atividade1.setNome("Algoritmos e Estrutura de dados");
        atividade1.setDescricao("Atividade de algoritmos e estrutura de dados");
        atividade1.setCurso(curso);
        atividade1.setProfessor(professor1);
        atividade1 = atividadeRepository.save(atividade1);

        // Create Nota 1
        Nota nota1 = new Nota();
        nota1.setValor(10.0);
        nota1.setAtividade(atividade1);
        nota1 = notaRepository.save(nota1);

        // Set relationships for Professor 1
        professor1.setCursos(Collections.singletonList(curso));
        professor1.setAtividades(Collections.singletonList(atividade1));
        professorRepository.save(professor1);

        curso.setAlunos(Collections.singletonList(aluno1));
        curso.setAtividades(Collections.singletonList(atividade1));
        cursoRepository.save(curso);

        atividade1.setNotas(Collections.singletonList(nota1));
        atividadeRepository.save(atividade1);

        // Create Professor 2
        Professor professor2 = new Professor();
        professor2.setNome("Ana Silva");
        professor2 = professorRepository.save(professor2);

        // Create Atividade 2
        Atividade atividade2 = new Atividade();
        atividade2.setNome("Programação Orientada a Objetos");
        atividade2.setDescricao("Atividade de programação orientada a objetos");
        atividade2.setProfessor(professor2);
        atividade2 = atividadeRepository.save(atividade2);

        // Create Nota 2
        Nota nota2 = new Nota();
        nota2.setValor(9.5);
        nota2.setAtividade(atividade2);
        nota2 = notaRepository.save(nota2);

        // Set relationships for Professor 2
        professor2.setAtividades(Collections.singletonList(atividade2));
        professorRepository.save(professor2);

        atividade2.setNotas(Collections.singletonList(nota2));
        atividadeRepository.save(atividade2);
    }
}