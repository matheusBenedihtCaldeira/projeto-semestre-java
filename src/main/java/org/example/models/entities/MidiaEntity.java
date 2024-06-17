package org.example.models.entities;

import java.util.Scanner;

public abstract class MidiaEntity {
    private String titulo;
    private String diretor;
    private String streaming;

    private AvaliacaoEntity avaliacao = new AvaliacaoEntity();
    public MidiaEntity() {
    }

    public MidiaEntity(String titulo, String diretor, String streaming) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.streaming = streaming;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getStreaming() {
        return streaming;
    }

    public void setStreaming(String streaming) {
        this.streaming = streaming;
    }

    public AvaliacaoEntity getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(AvaliacaoEntity avaliacao) {
        this.avaliacao = avaliacao;
    }

    public abstract String getDetalhes();
    public abstract void atualizar(Scanner sc);
}