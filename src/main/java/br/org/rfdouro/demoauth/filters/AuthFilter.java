package br.org.rfdouro.demoauth.filters;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import br.org.rfdouro.demoauth.data.Autorizacao;
import br.org.rfdouro.demoauth.data.AutorizacaoRepository;
import br.org.rfdouro.demoauth.data.Usuario;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
// @WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

 @Autowired
 AutorizacaoRepository autorizacaoRepository;

 @Override
 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
   throws IOException, ServletException {

  String context = request.getServletContext().getContextPath();

  String url = request instanceof HttpServletRequest
    ? ((HttpServletRequest) request).getRequestURL().toString()
    : "N/A";

  try {
   URL _url = new URI(url).toURL();
   url = _url.getFile();
   url = url.replace(context, "");
  } catch (URISyntaxException e) {
   e.printStackTrace();
  }

  System.out.println("processando a url: " + url);

  var usuLogado = request instanceof HttpServletRequest
    ? ((HttpServletRequest) request).getSession().getAttribute("usuario")
    : null;

  System.out.println("usuário logado : " + usuLogado);

  // se não precisar de permissão segue em frente
  if (!(autorizacaoRepository.precisaVerificar(url) > 0)) {
   chain.doFilter(request, response);
   return;
  }

  // se precisa de permissão verifica se tem usuário logado
  if (usuLogado != null) {
   Usuario u = (Usuario) usuLogado;
   if (u.getAutorizacoes() != null) {
    for (Autorizacao a : u.getAutorizacoes()) {
     System.out.println(a.getPattern());

     Pattern pattern = Pattern.compile(a.getPattern(), Pattern.UNICODE_CASE);
     Matcher matcher = pattern.matcher(url);
     boolean matchFound = matcher.find();
     if (matchFound) {
      System.out.println("ok aqui");
      chain.doFilter(request, response);
      return;
     }
    }
   }
   request.getRequestDispatcher("/naoautorizado").forward(request, response);
   return; // recusa a navegação e direciona para a página naoautorizado
  } else {
   request.getRequestDispatcher("/login").forward(request, response);
   return; // direciona para o login
  }
 }

}
