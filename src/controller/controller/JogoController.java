package controller;

import java.util.*;
import model.BancoDeDados;


public class JogoController {
    private BancoDeDados bancoDeDados;
    
    public JogoController() {
        this.bancoDeDados = new BancoDeDados(null, null, null, null);
    }

    public void adicionarJogo(String titulo, String genero, String plataforma, String valor) {
        BancoDeDados jogo = new BancoDeDados(titulo, genero, plataforma, valor);
        bancoDeDados.adicionarJogo(jogo);
    }
    public void listarJogos() {
        for (BancoDeDados jogo : bancoDeDados.getJogos()) {
            System.out.println("Título: " + jogo.getTitulo());
            System.out.println("Gênero: " + jogo.getGenero());
            System.out.println("Plataforma: " + jogo.getPlataforma());
            System.out.println("Valor: " + jogo.getValor());
            System.out.println("------------------------------");
        }
    }
    public void removerJogo(String titulo) {
        ArrayList<BancoDeDados> jogos = bancoDeDados.getJogos();
        for (int i = 0; i < jogos.size(); i++) {
            if (jogos.get(i).getTitulo().equals(titulo)) {
                jogos.remove(i);
                System.out.println("Jogo removido com sucesso!");
                return;
            }
        }
        System.out.println("Jogo não encontrado.");
    }
    public void atualizarJogo(String titulo, String novoTitulo, String novoGenero, String novaPlataforma, String novoValor) {
        ArrayList<BancoDeDados> jogos = bancoDeDados.getJogos();
        for (BancoDeDados jogo : jogos) {
            if (jogo.getTitulo().equals(titulo)) {
                jogo.setTitulo(novoTitulo);
                jogo.setGenero(novoGenero);
                jogo.setPlataforma(novaPlataforma);
                jogo.setValor(novoValor);
                System.out.println("Jogo atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Jogo não encontrado.");
    }
    public void buscarJogo(String titulo) {
        ArrayList<BancoDeDados> jogos = bancoDeDados.getJogos();
        for (BancoDeDados jogo : jogos) {
            if (jogo.getTitulo().equals(titulo)) {
                System.out.println("Título: " + jogo.getTitulo());
                System.out.println("Gênero: " + jogo.getGenero());
                System.out.println("Plataforma: " + jogo.getPlataforma());
                System.out.println("Valor: " + jogo.getValor());
                return;
            }
        }
        System.out.println("Jogo não encontrado.");
    }
}
