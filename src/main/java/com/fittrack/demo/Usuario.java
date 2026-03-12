package com.fittrack.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int idade;
	private double peso;
	private double altura;
	
	// CONSTRUCTORS:
	
	// Aqui criei um construtor que instancia os atributos da classe Usuario.
	public Usuario(String nome, int idade, double peso, double altura) {
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
		this.peso = peso;
	}
	
	// Aqui vamos fazer uma sobrecarga de construtor pedindo para o cliente passar apenas nome e idade.
	public Usuario(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public Usuario() {}
	
	// GETTERS AND SETTERS:
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public void setIdade(int novaIdade) {
		
		if(novaIdade > 0) {
			this.idade = novaIdade;
		}else {
			System.out.println("A idade tem quer ser maior que 0!");
		}
		
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public void setPeso(double novoPeso) {
		
		if(novoPeso > 0) {
			this.peso = novoPeso;
		}else {
			System.out.println("O peso tem que ser maior que 0!");
		}
	}
	
	public double getAltura() {
		return this.altura;
	}
	
	public void setAltura(double novaAltura) {
		this.altura = novaAltura;
	}
}
