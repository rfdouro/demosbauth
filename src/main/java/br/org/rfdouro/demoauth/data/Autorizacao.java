package br.org.rfdouro.demoauth.data;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(indexes = {
  @Index(columnList = "nome", unique = true)
})
public class Autorizacao {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String nome;
 private String pattern;
 @ManyToMany(mappedBy = "autorizacoes", fetch = FetchType.LAZY)
 private List<Usuario> autorizados;

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getNome() {
  return nome;
 }

 public void setNome(String nome) {
  this.nome = nome;
 }

 public String getPattern() {
  return pattern;
 }

 public void setPattern(String pattern) {
  this.pattern = pattern;
 }

 public List<Usuario> getAutorizados() {
  return autorizados;
 }

 public void setAutorizados(List<Usuario> autorizados) {
  this.autorizados = autorizados;
 }
}
