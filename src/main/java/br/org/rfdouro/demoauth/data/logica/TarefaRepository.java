package br.org.rfdouro.demoauth.data.logica;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

 List<Tarefa> findAllByIdUsuarioOrderByDescricao(Long idUsuario);
 
}
