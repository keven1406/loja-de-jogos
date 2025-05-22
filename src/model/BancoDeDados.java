package model;
import java.util.*;


public class BancoDeDados {
    private String Titulo;
    private String Genero;
    private String Plataforma;
    private String Valor;
    
    public BancoDeDados(String Titulo, String Genero, String Plataforma, String Valor) {
        this.Titulo = Titulo;
        this.Genero = Genero;
        this.Plataforma = Plataforma;
        this.Valor = Valor;
    }
    public String getTitulo() {
        return Titulo;
    
    }
    public void setTitulo(String Titulo){
        this.Titulo = Titulo;
    }
    public String getGenero() {
        return Genero;
    }
    public void setGenero(String Genero){
        this.Genero = Genero;
    }
    public String getPlataforma() {
        return Plataforma;
    }
    public void setPlataforma(String Plataforma){
        this.Plataforma = Plataforma;
    }
    public String getValor() {
        return Valor;
    }
    public void setValor(String Valor){
        this.Valor = Valor;
    }
   
    
    private ArrayList<BancoDeDados> jogos = new ArrayList<>();
    public void adicionarJogo(BancoDeDados jogo) {
        jogos.add(jogo);
    }
    public ArrayList<BancoDeDados> getJogos() {
        return jogos;
    }

}