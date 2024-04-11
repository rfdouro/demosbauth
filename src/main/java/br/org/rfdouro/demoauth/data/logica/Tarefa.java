package br.org.rfdouro.demoauth.data.logica;

import br.org.rfdouro.demoauth.data.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Table(name = "TAREFA")
public class Tarefa {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String descricao;
 private  Long idUsuario;

 public Long getIdUsuario() {
  return idUsuario;
 }

 public void setIdUsuario(Long idUsuario) {
  this.idUsuario = idUsuario;
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getDescricao() {
  return descricao;
 }

 public void setDescricao(String descricao) {
  this.descricao = descricao;
 }

}
