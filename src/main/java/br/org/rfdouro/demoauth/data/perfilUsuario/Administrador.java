package br.org.rfdouro.demoauth.data.perfilUsuario;

import br.org.rfdouro.demoauth.data.Usuario;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Administrador")
public class Administrador extends Usuario {
 
}
