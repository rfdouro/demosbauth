package br.org.rfdouro.demoauth.controls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.rfdouro.demoauth.data.Autorizacao;
import br.org.rfdouro.demoauth.data.Usuario;
import br.org.rfdouro.demoauth.data.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

 @Autowired
 HttpServletRequest request;
 @Autowired
 UsuarioRepository usuarioRepository;

 @GetMapping
 public String login() {
  return "login";
 }

 @GetMapping("/deslogar")
 public String deslogar() {
  request.getSession().removeAttribute("usuario");
  return "redirect:/index";
 }

 @PostMapping
 public String logar(Model model, String usuario, String senha) {
  if (usuario != null && !usuario.equals("") && senha != null) {
   Usuario u = usuarioRepository.findByLoginAndSenha(usuario, senha);
   if (u != null) {
    System.out.println(u.getAutorizacoes());
    if(u.getAutorizacoes()!=null)
    for(Autorizacao a: u.getAutorizacoes()){
     System.out.println(a.getPattern());
    }
    request.getSession().setAttribute("usuario", u);
    return "redirect:/index";
   }else{
    model.addAttribute("mensagem", "dados não conferem");
    return "login";
   }
  }
  model.addAttribute("mensagem", "dados não digitados");
  return "login";
 }
}
