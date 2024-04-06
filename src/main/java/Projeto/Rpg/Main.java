package Projeto.Rpg;


public class Main {
    public static void main(String[] args) {
        GeneratorQuest generate = new GeneratorQuest();

        for (int i = 0; i < 3; i++) {
            Player player = generate.generatePlayer();
        }
    }
}