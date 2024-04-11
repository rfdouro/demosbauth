package br.org.rfdouro.demoauth.data.perfilUsuario;

import br.org.rfdouro.demoauth.data.Usuario;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Professor")
public class Professor extends Usuario {
 private String matricula;
 private Integer anoAdmissao;

 public String getMatricula() {
  return matricula;
 }

 public void setMatricula(String matricula) {
  this.matricula = matricula;
 }

 public Integer getAnoAdmissao() {
  return anoAdmissao;
 }

 public void setAnoAdmissao(Integer anoAdmissao) {
  this.anoAdmissao = anoAdmissao;
 }

}
