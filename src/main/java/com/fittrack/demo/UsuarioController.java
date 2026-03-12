package com.fittrack.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Aqui estamos avisando o Spring que é uma API Rest
@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	// Essa anotação seria tipo um app.get() do Node.js
	@GetMapping("/usuario")
	public List<Usuario> buscarUsuario() {
		// Aqui estamos puxando o constructor la que criamos no arquivo Usuario com os atributos completos.
		Usuario meuUsuario = new Usuario("Vinicius", 18, 70.0, 1.70);
		
		// O Spring converte o objeto Java automaticamente para JSON na tela.
		return repository.findAll();
	}
	
	// Aqui essa anotação seria o app.post() do Node.js
	@PostMapping("/usuario")
	// Note que agora o retorno não é só "Usuario", é um "ResponseEntity" que carrega um Usuario dentro!
	public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario novoUsuario) {
		
		// Aqui o Spring pega o JSON do Postman e ja converte em um objeto Usuario novinho
		
		// O save() faz um "INSERT INTO usuario..." automaticamente!
		Usuario usuarioSalvo = repository.save(novoUsuario);
		
		// Aqui provamos que deu certo mostrando essa mensagem no terminal do Eclipse:
		System.out.println("Recebemos um POST para cadastrar o aluno: " + novoUsuario.getNome());
		
		// Aqui retornamos o proprio usuario para o Postman ver que deu certo (Status: 200 OK)
		// Aqui está a mágica: Devolvemos o Status 201 (Created) e colocamos o JSON no "body"
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}
	
	
	// no Node.js usamos /:peso/:altura. No Spring Boot usamos {}
	@GetMapping("/imc/{peso}/{altura}")
	public String calcularIMC(@PathVariable double peso, @PathVariable double altura) {
		
		// Aqui vamos fazer o calculo do IMC:
		double imc = peso / (altura * altura);
		
		// Retornamos uma mensagem personalizada
		return "O IMC calculado para o peso " + peso + " e altura " + altura + " é: " + imc;
	}
	
	@GetMapping("/count")
	public Long contarUsuario() {
		return repository.count();
	}
	
}
