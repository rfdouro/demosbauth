package br.org.rfdouro.demoauth.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {
 @Query(nativeQuery = true, value = "SELECT COUNT(ID) > 0 FROM PUBLIC.AUTORIZACAO WHERE ?1 REGEXP PATTERN")
 Boolean precisaVerificar(String url);
}
