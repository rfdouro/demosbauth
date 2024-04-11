package br.org.rfdouro.demoauth.services;

import org.springframework.stereotype.Service;

import br.org.rfdouro.demoauth.data.Usuario;

@Service
public class UsuarioService {
 public String tipoUsuario(Usuario u){
  return u.getClass().getSimpleName();
 }
}
