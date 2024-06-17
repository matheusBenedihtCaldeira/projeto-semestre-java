package org.example.models.entities;

public class AvaliacaoEntity {
    private MidiaEntity midia;
    private int nota;

    public AvaliacaoEntity() {
    }

    public AvaliacaoEntity(MidiaEntity midia, int nota) {
        this.midia = midia;
        this.nota = nota;
    }

    public MidiaEntity getMidia() {
        return midia;
    }

    public void setMidia(MidiaEntity midia) {
        this.midia = midia;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Titulo: " + this.midia.getTitulo() + "\nNota: " + this.getNota();
    }
}