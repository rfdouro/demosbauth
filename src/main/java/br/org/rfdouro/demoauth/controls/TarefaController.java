package br.org.rfdouro.demoauth.controls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {

 @GetMapping
 public String index() {
  return "tarefa/index";
 }
}
