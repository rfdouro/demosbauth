package br.org.rfdouro.demoauth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.annotation.PostConstruct;

@ServletComponentScan
@SpringBootApplication
public class DemoauthApplication {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoauthApplication.class, args);
	}

	@PostConstruct
	private void initDb() {
		try {
			String sqlStatements[] = {
					"INSERT INTO PUBLIC.USUARIO\r\n" + //
							"(LOGIN, SENHA)\r\n" + //
							"VALUES('admin', '1234');\r\n" + //
							"",
					"INSERT INTO PUBLIC.USUARIO\r\n" + //
							"(LOGIN, SENHA)\r\n" + //
							"VALUES('usuario', '1234');\r\n" + //
							"",
					"INSERT INTO PUBLIC.AUTORIZACAO\r\n" + //
							"(NOME, PATTERN)\r\n" + //
							"VALUES('ADMIN', '^/admin');\r\n" + //
							"",
					"INSERT INTO PUBLIC.AUTORIZACAO\r\n" + //
							"(NOME, PATTERN)\r\n" + //
							"VALUES('TAREFA', '^/tarefa');\r\n" + //
							"",
					"INSERT INTO PUBLIC.AUTORIZACOES_FUNCIONARIOS\r\n" + //
							"(AUTH_ID, USUARIO_ID)\r\n" + //
							"VALUES((SELECT ID\r\n" + //
							"FROM PUBLIC.AUTORIZACAO WHERE NOME = 'ADMIN'), (SELECT ID\r\n" + //
							"FROM PUBLIC.USUARIO WHERE LOGIN = 'admin'));\r\n" + //
							"",
					"INSERT INTO PUBLIC.AUTORIZACOES_FUNCIONARIOS\r\n" + //
							"(AUTH_ID, USUARIO_ID)\r\n" + //
							"VALUES((SELECT ID\r\n" + //
							"FROM PUBLIC.AUTORIZACAO WHERE NOME = 'TAREFA'), (SELECT ID\r\n" + //
							"FROM PUBLIC.USUARIO WHERE LOGIN = 'usuario'));\r\n" + //
							""
			};

			Arrays.asList(sqlStatements).forEach(sql -> {
				jdbcTemplate.execute(sql);
			});
		} catch (Exception ex) {

		}
	}

}
