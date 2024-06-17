package org.example.models.entities;

import java.util.Scanner;

public class SerieEntity extends MidiaEntity{
    private int temporadas;

    public SerieEntity() {
    }
    public SerieEntity(String titulo, String diretor, String streaming, int temporadas, int episodios) {
        super(titulo, diretor, streaming);
        this.temporadas = temporadas;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    @Override
    public String getDetalhes() {
        return "Série: " + getTitulo() + ", Diretor: " + getDiretor() + ", Streaming: " + getStreaming() + ", Temporadas: " + temporadas + ", Sua nota: " + this.getAvaliacao().getNota();
    }

    @Override
    public void atualizar(Scanner sc) {
        System.out.print("Novo título (atual: " + getTitulo() + "): ");
        String novoTitulo = sc.nextLine();
        if (!novoTitulo.isEmpty()) {
            setTitulo(novoTitulo);
        }

        System.out.print("Novo diretor (atual: " + getDiretor() + "): ");
        String novoDiretor = sc.nextLine();
        if (!novoDiretor.isEmpty()) {
            setDiretor(novoDiretor);
        }

        System.out.print("Nova plataforma de streaming (atual: " + getStreaming() + "): ");
        String novaPlataforma = sc.nextLine();
        if (!novaPlataforma.isEmpty()) {
            setStreaming(novaPlataforma);
        }

        System.out.print("Nova quantidade de temporadas (atual: " + temporadas + "): ");
        String novaTemporadas = sc.nextLine();
        if (!novaTemporadas.isEmpty()) {
            setTemporadas(Integer.parseInt(novaTemporadas));
        }

        System.out.println("Série atualizada com sucesso!");
    }
}