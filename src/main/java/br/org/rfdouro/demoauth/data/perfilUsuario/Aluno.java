package br.org.rfdouro.demoauth.data.perfilUsuario;

import br.org.rfdouro.demoauth.data.Usuario;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Aluno")
public class Aluno extends Usuario {
 private String matricula;
 private Integer anoIngresso;
 private Integer anoConclusao;

 public String getMatricula() {
  return matricula;
 }

 public void setMatricula(String matricula) {
  this.matricula = matricula;
 }

 public Integer getAnoIngresso() {
  return anoIngresso;
 }

 public void setAnoIngresso(Integer anoIngresso) {
  this.anoIngresso = anoIngresso;
 }

 public Integer getAnoConclusao() {
  return anoConclusao;
 }

 public void setAnoConclusao(Integer anoConclusao) {
  this.anoConclusao = anoConclusao;
 }

}
