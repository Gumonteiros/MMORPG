package Projeto.Rpg;

public class Player {
    private String nome;
    private String classe;
    private String rank;
    private Integer nivel;
    private String quest;

    public Player(String nome, String classe, String rank, Integer nivel, String quest) {
        this.nome = nome;
        this.classe = classe;
        this.rank = rank;
        this.nivel = nivel;
        this.quest = quest;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }



}
