package br.org.rfdouro.demoauth.controls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.rfdouro.demoauth.data.AutorizacaoRepository;
import br.org.rfdouro.demoauth.data.Usuario;
import br.org.rfdouro.demoauth.data.UsuarioRepository;
import br.org.rfdouro.demoauth.data.logica.Tarefa;

@Controller
@RequestMapping("/admin")
public class AdminController {

 @Autowired
 UsuarioRepository usuarioRepository;

 @Autowired
 AutorizacaoRepository autorizacaoRepository;

 @GetMapping({ "", "/", "/index" })
 public String admin(Model model) {
  model.addAttribute("listaUsuarios", usuarioRepository.findAll(Sort.by("login")));
  return "admin/index";
 }

 @GetMapping({ "/usuario/cadastro" })
 public String abrecadastrousuario(Model model) {
  model.addAttribute("listaAutorizacoes", autorizacaoRepository.findAll(Sort.by("nome")));
  return "admin/cadusuario";
 }

 @PostMapping(value = "/usuario/cadastro", consumes = "application/x-www-form-urlencoded")
 public String cadastrar(Usuario usuario) {
  usuarioRepository.save(usuario);
  return "redirect:/admin";
 }

 @GetMapping({ "/usuario/delete/{id}" })
 public String deleteusuario(@PathVariable(name = "id", required = true) Long id) {
  usuarioRepository.deleteById(id);
  return "redirect:/admin/";
 }

 @PostMapping({ "/usuario/add" })
 public String addusuario(String login, String senha) {
  Usuario u = new Usuario();
  u.setLogin(login);
  u.setSenha(senha);
  usuarioRepository.save(u);
  return "redirect:/admin/";
 }

}
