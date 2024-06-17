package org.example.models.entities;

import java.util.Scanner;

public class FilmeEntity extends MidiaEntity{

    private int duracao;

    public FilmeEntity() {
    }

    public FilmeEntity(String titulo, String diretor, String streaming, int duracao) {
        super(titulo, diretor, streaming);
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String getDetalhes() {
        return "Filme: " + getTitulo() + ", Diretor: " + getDiretor() + ", Streaming: " + getStreaming() + ", Duração: " + duracao + " minutos." + ", Sua nota: " + this.getAvaliacao().getNota();
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

        System.out.print("Nova duração (atual: " + duracao + " minutos): ");
        String novaDuracao = sc.nextLine();
        if (!novaDuracao.isEmpty()) {
            setDuracao(Integer.parseInt(novaDuracao));
        }

        System.out.println("Filme atualizado com sucesso!");
    }
}