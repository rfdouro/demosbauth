package br.org.rfdouro.demoauth.data;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(indexes = {
  @Index(columnList = "login", unique = true)
})
public class Usuario {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String login;
 private String senha;
 @ManyToMany
 @JoinTable(name = "autorizacoes_funcionarios", joinColumns = { @JoinColumn(name = "auth_id") }, inverseJoinColumns = {
   @JoinColumn(name = "usuario_id") })
 private List<Autorizacao> autorizacoes;

 public List<Autorizacao> getAutorizacoes() {
  return autorizacoes;
}

public void setAutorizacoes(List<Autorizacao> autorizacoes) {
  this.autorizacoes = autorizacoes;
}

public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getLogin() {
  return login;
 }

 public void setLogin(String login) {
  this.login = login;
 }

 public String getSenha() {
  return senha;
 }

 public void setSenha(String senha) {
  this.senha = senha;
 }

}
