package br.org.rfdouro.demoauth.controls.logica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.rfdouro.demoauth.data.logica.Tarefa;
import br.org.rfdouro.demoauth.data.logica.TarefaRepository;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {

 @Autowired
 TarefaRepository tarefaRepository;

 @GetMapping("/cadastro")
 public String cadastro() {
  return "tarefa/cadastro";
 }

 @GetMapping
 public String index(Model model) {
  model.addAttribute("listaTarefas", tarefaRepository.findAll());
  return "tarefa/index";
 }

 @PostMapping
 public String cadastrar(String descricao) {
  Tarefa tarefa = new Tarefa();
  tarefa.setDescricao(descricao);
  tarefaRepository.save(tarefa);
  return "redirect:/tarefa";
 }

 @GetMapping("/excluir/{id}")
 public String excluir(@PathVariable(name = "id", required = true) Long id) {
  tarefaRepository.deleteById(id);
  return "redirect:/tarefa";
 }

}
