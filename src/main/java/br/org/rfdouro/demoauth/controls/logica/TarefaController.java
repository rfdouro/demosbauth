package br.org.rfdouro.demoauth.controls.logica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.rfdouro.demoauth.data.logica.Tarefa;
import br.org.rfdouro.demoauth.data.logica.TarefaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {

 @Autowired
 TarefaRepository tarefaRepository;

 @GetMapping
 public String index(Model model) {
  model.addAttribute("listaTarefas", tarefaRepository.findAll());
  return "tarefa/index";
 }

 @PostMapping
 public String postMethodName(@RequestBody Tarefa tarefa) {
  tarefaRepository.save(tarefa); 
  return "redirect:/tarefa";
 }

}
