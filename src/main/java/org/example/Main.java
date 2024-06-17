package org.example;

import org.example.models.entities.AvaliacaoEntity;
import org.example.models.entities.FilmeEntity;
import org.example.models.entities.MidiaEntity;
import org.example.models.entities.SerieEntity;
import org.example.models.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opt;
        List<UserEntity> users = new ArrayList<>();
        List<MidiaEntity> midias = new ArrayList<>();
        do {
            mostrarMenuLogin();
            opt = sc.nextInt();
            sc.nextLine();
            if (opt == 1) {
                System.out.println("Operações de login");
            } else if (opt == 2) {
                UserEntity user = new UserEntity();
                System.out.print("Digite seu nome completo: ");
                user.setName(sc.nextLine());
                System.out.print("Digite seu e-mail: ");
                user.setEmail(sc.nextLine());
                System.out.print("Digite sua senha: ");
                user.setPassword(sc.nextLine());
                users.add(user);
            } else {
                break;
            }
            do {
                mostrarMenu();
                opt = sc.nextInt();
                sc.nextLine();
                switch (opt) {
                    case 1:
                        FilmeEntity filme = new FilmeEntity();
                        System.out.println("==================");
                        System.out.print("Digite o titulo do filme: ");
                        filme.setTitulo(sc.nextLine());
                        System.out.print("Digite o nome do diretor: ");
                        filme.setDiretor(sc.nextLine());
                        System.out.print("Digite a plataforma de streaming onde assistiu: ");
                        filme.setStreaming(sc.nextLine());
                        System.out.print("Digite a duração em minutos: ");
                        filme.setDuracao(sc.nextInt());
                        sc.nextLine();
                        midias.add(filme);
                        break;
                    case 2:
                        listarMidias(midias, "FilmeEntity");
                        break;
                    case 3:
                        System.out.println("==================");
                        System.out.print("Digite o nome do filme: ");
                        var titulo = sc.nextLine();
                        MidiaEntity midiaEncontrada = buscarMidia(midias, titulo);
                        if (midiaEncontrada != null) {
                            System.out.println(midiaEncontrada.getDetalhes());
                        } else {
                            System.out.println("Filme não encontrado!");
                        }
                        break;
                    case 4:
                        System.out.println("==================");
                        System.out.print("Digite o nome do titulo que deseja excluir: ");
                        String filmeExc = sc.nextLine();
                        MidiaEntity midiaExcluir = buscarMidia(midias, filmeExc);
                        if (midiaExcluir != null) {
                            midias.remove(midiaExcluir);
                            System.out.println("Filme excluido!");
                        } else {
                            System.out.println("Filme não encontrado!");
                        }
                        break;
                    case 5:
                        SerieEntity serieEntity = new SerieEntity();
                        System.out.println("==================");
                        System.out.print("Digite o nome da série: ");
                        serieEntity.setTitulo(sc.nextLine());
                        System.out.print("Digite o nome do diretor: ");
                        serieEntity.setDiretor(sc.nextLine());
                        System.out.print("Digite a plataforma de streaming onde assistiu: ");
                        serieEntity.setStreaming(sc.nextLine());
                        System.out.print("Digite a quantidade de temporadas: ");
                        serieEntity.setTemporadas(sc.nextInt());
                        sc.nextLine();
                        midias.add(serieEntity);
                        break;
                    case 6:
                        listarMidias(midias, "SerieEntity");
                        break;
                    case 7:
                        System.out.println("==================");
                        System.out.print("Digite o nome da série: ");
                        var tituloSerieBusca = sc.nextLine();
                        MidiaEntity serieEncontrada = buscarMidia(midias, tituloSerieBusca);
                        if (serieEncontrada != null) {
                            System.out.println(serieEncontrada.getDetalhes());
                        } else {
                            System.out.println("Serie não encontrada!");
                        }
                        break;
                    case 8:
                        System.out.println("==================");
                        System.out.print("Digite o nome da série que deseja excluir: ");
                        String serieExc = sc.nextLine();
                        MidiaEntity serieExcluir = buscarMidia(midias, serieExc);
                        if (serieExcluir != null) {
                            midias.remove(serieExcluir);
                            System.out.println("Serie excluida!");
                        } else {
                            System.out.println("Serie não encontrada!");
                        }
                        break;
                    case 9:
                        menuAvaliacao();
                        opt = sc.nextInt();
                        sc.nextLine();
                        if (opt == 1) {
                            System.out.print("Digite o nome do filme que deseja avaliar: ");
                            var filmeAvaliacao = sc.nextLine();
                            System.out.print("Digite uma nota de 0 a 10: ");
                            var notaFilme = sc.nextInt();
                            avaliacaoMidia(midias, filmeAvaliacao, notaFilme);
                        } else if (opt == 2) {
                            System.out.print("Digite o nome da série que deseja avaliar: ");
                            var serieAvaliacao = sc.nextLine();
                            System.out.print("Digite uma nota de 0 a 10: ");
                            var notaSerie = sc.nextInt();
                            avaliacaoMidia(midias, serieAvaliacao, notaSerie);
                        }
                        break;
                    case 10:
                        atualizarMidia(midias, sc);
                        break;
                    case 0:
                        break;
                }
            } while (opt != 0);
        } while (opt != 0);
    }

    public static void atualizarMidia(List<MidiaEntity> midias, Scanner sc) {
        System.out.println("==================");
        System.out.print("Digite o nome da mídia que deseja atualizar: ");
        String tituloAtualizar = sc.nextLine();
        MidiaEntity midiaAtualizar = buscarMidia(midias, tituloAtualizar);
        if (midiaAtualizar != null) {
            midiaAtualizar.atualizar(sc);
        } else {
            System.out.println("Mídia não encontrada!");
        }
    }

    public static void avaliacaoMidia(List<MidiaEntity> midias, String titulo, int nota) {
        MidiaEntity midia = buscarMidia(midias, titulo);
        if (midia != null) {
            AvaliacaoEntity avaliacaoEntity = new AvaliacaoEntity();
            avaliacaoEntity.setMidia(midia);
            avaliacaoEntity.setNota(nota);
            midia.setAvaliacao(avaliacaoEntity);
            System.out.println("Avaliação registrada!");
        } else {
            System.out.println("Mídia não encontrada!");
        }
    }

    public static void menuAvaliacao() {
        System.out.println("Avaliar filme");
        System.out.println("Você deseja avaliar um filme ou serie? ");
        System.out.println("1 - Filme");
        System.out.println("2 - Serie");
        System.out.print("Digite a opção: ");
    }

    public static void mostrarMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1 - Cadastrar filme");
        System.out.println("2 - Listar filmes");
        System.out.println("3 - Buscar filme");
        System.out.println("4 - Excluir filme");
        System.out.println("5 - Cadastrar série");
        System.out.println("6 - Listar series");
        System.out.println("7 - Buscar serie");
        System.out.println("8 - Excluir serie");
        System.out.println("9 - Avaliar");
        System.out.println("10 - Atualizar mídia");
        System.out.println("0 - Fechar programa");
        System.out.print("Selecione uma opção: ");
    }

    public static void mostrarMenuLogin() {
        System.out.println("===== Sistema de Avaliação de Filmes e Series =====");
        System.out.println("1 - Login");
        System.out.println("2 - Registrar-se");
        System.out.print("Selecione uma opção: ");
    }

    public static MidiaEntity buscarMidia(List<MidiaEntity> midias, String titulo) {
        for (MidiaEntity midia : midias) {
            if (midia.getTitulo().equalsIgnoreCase(titulo)) {
                return midia;
            }
        }
        return null;
    }

    public static void listarMidias(List<MidiaEntity> midias, String tipo) {
        for (MidiaEntity midia : midias) {
            if (midia.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                System.out.println(midia.getDetalhes());
            }
        }
    }
}
