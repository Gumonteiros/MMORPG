package Projeto.Rpg;

import Api.ApiServer;

public class Main {
    public static void main(String[] args) {
        // Executar o servidor da API
        ApiServer apiServer = new ApiServer();
        apiServer.main(args);

        // Gerar os jogadores
        GeneratorQuest generate = new GeneratorQuest();
        for (int i = 0; i < 3; i++) {
            Player player = generate.generatePlayer();
        }
    }
}