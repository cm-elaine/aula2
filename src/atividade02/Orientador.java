package atividade02;

import java.util.ArrayList;
import java.util.List;

public class Orientador {
	
	private String nome;
	private List<Estudante> estudantes = new ArrayList<>();

	public Orientador(String nome) {
		this.nome = nome;
	}

	public void adicionarEstudante(Estudante estudante) {
		if(estudantes.size() >=2) {
			throw new LimiteEstudantesException("Limite de estudantes atingido para o orientador: " + nome);
		}
		estudantes.add(estudante);
		estudante.adicionarOrientador(this);
	}

// Testando
	public static void main(String[] args) {
        try {
            Orientador orientador = new Orientador("Dory");

            Estudante estudante1 = new Estudante(1);
            Estudante estudante2 = new Estudante(2);
            Estudante estudante3 = new Estudante(3);

            orientador.adicionarEstudante(estudante1);
            orientador.adicionarEstudante(estudante2);
            orientador.adicionarEstudante(estudante3); // lançando exceção

        } catch (LimiteEstudantesException e) {
            System.out.println("Exceção: " + e.getMessage());
        }
    }
}


