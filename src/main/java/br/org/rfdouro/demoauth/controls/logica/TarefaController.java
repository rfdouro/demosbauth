package br.org.rfdouro.demoauth.controls.logica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.rfdouro.demoauth.data.Usuario;
import br.org.rfdouro.demoauth.data.logica.Tarefa;
import br.org.rfdouro.demoauth.data.logica.TarefaRepository;
import jakarta.servlet.http.HttpServletRequest;

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
 public String index(Model model, HttpServletRequest request) {
  Usuario u = (Usuario) request.getSession().getAttribute("usuario");
  model.addAttribute("listaTarefas", tarefaRepository.findAllByIdUsuarioOrderByDescricao(u.getId()));
  return "tarefa/index";
 }

 /*
  * para REST o consumo padrão é JSON
  * consumes = "application/json"
  * aqui estamos utilizando o envio através de um FORM 
  */
 @PostMapping(consumes = "application/x-www-form-urlencoded")
 public String cadastrar(HttpServletRequest request, Tarefa tarefa) {
  Usuario u = (Usuario) request.getSession().getAttribute("usuario");
  tarefa.setIdUsuario(u.getId());
  tarefaRepository.save(tarefa);
  return "redirect:/tarefa";
 }

 @GetMapping("/excluir/{id}")
 public String excluir(@PathVariable(name = "id", required = true) Long id) {
  tarefaRepository.deleteById(id);
  return "redirect:/tarefa";
 }

}
