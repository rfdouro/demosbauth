package br.org.rfdouro.demoauth.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {
 @Query(nativeQuery = true, value = "select COUNT(ID) FROM AUTORIZACAO WHERE ?1 REGEXP CONCAT('(?i)', PATTERN) ")
 Long precisaVerificar(String url);

 //@Query(nativeQuery = true, value = "SELECT COUNT(ID) FROM AUTORIZACAO WHERE ?1 REGEXP PATTERN")
 //Long precisaVerificar(String url);
}
