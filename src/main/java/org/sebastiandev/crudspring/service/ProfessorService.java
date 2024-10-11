package org.sebastiandev.crudspring.service;

import org.sebastiandev.crudspring.model.Aluno;
import org.sebastiandev.crudspring.model.Atividade;
import org.sebastiandev.crudspring.model.Curso;
import org.sebastiandev.crudspring.model.Professor;
import org.sebastiandev.crudspring.repository.AlunoRepository;
import org.sebastiandev.crudspring.repository.AtividadeRepository;
import org.sebastiandev.crudspring.repository.CursoRepository; // Importação adicionada
import org.sebastiandev.crudspring.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional; // Importação para transações
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository; // Injeção do CursoRepository

    public List<Professor> getProfessores() {
        return professorRepository.findAll();
    }

    public Professor getProfessor(Long professorId) {
        return professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
    }

    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor updateProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public void deleteProfessor(Long professorId) {
        professorRepository.deleteById(professorId);
    }

    /**
     * Método para criar uma nova atividade, vincular ao professor e ao curso
     *
     * @param professorId ID do professor
     * @param cursoId     ID do curso
     * @param atividade   Objeto Atividade a ser criado
     * @return Atividade criada e vinculada
     */
    @Transactional
    public Atividade criarAtividade(Long professorId, Long cursoId, Atividade atividade) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        // Vincula o professor à atividade
        atividade.setProfessor(professor);

        // Vincula a atividade ao curso
        atividade.setCurso(curso);
        curso.addAtividade(atividade); // Método de conveniência na entidade Curso

        // Salva a atividade
        return atividadeRepository.save(atividade);
    }

    /**
     * Método para atribuir uma atividade a um aluno
     *
     * @param atividadeId ID da atividade
     * @param alunoId     ID do aluno
     * @return Atividade atualizada
     */
    @Transactional
    public Atividade atribuirAtividade(Long atividadeId, Long alunoId) {
        Atividade atividade = atividadeRepository.findById(atividadeId)
                .orElseThrow(() -> new RuntimeException("Atividade não encontrada"));
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        // Atribui o aluno à atividade
        List<Aluno> alunos = atividade.getAlunos();
        if (!alunos.contains(aluno)) {
            alunos.add(aluno);
            atividade.setAlunos(alunos);
        }
        return atividadeRepository.save(atividade);
    }

    /**
     * Método para deletar uma atividade e desvinculá-la do curso
     *
     * @param atividadeId ID da atividade a ser deletada
     */
    @Transactional
    public void deletarAtividade(Long atividadeId) {
        Atividade atividade = atividadeRepository.findById(atividadeId)
                .orElseThrow(() -> new RuntimeException("Atividade não encontrada"));

        // Desvincula a atividade do curso
        Curso curso = atividade.getCurso();
        if (curso != null) {
            curso.removeAtividade(atividade); // Método de conveniência na entidade Curso
            cursoRepository.save(curso);
        }

        // Remove a atividade
        atividadeRepository.deleteById(atividadeId);
    }

    /**
     * Método para adicionar uma nota a uma atividade
     *
     * @param atividadeId ID da atividade
     * @param nota        Valor da nota
     * @return Atividade atualizada
     */
    @Transactional
    public Atividade adicionarNota(Long atividadeId, Double nota) {
        Atividade atividade = atividadeRepository.findById(atividadeId)
                .orElseThrow(() -> new RuntimeException("Atividade não encontrada"));
        atividade.setNota(nota); // Define a nota para a atividade
        return atividadeRepository.save(atividade);
    }
}
