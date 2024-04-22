package Projeto.Rpg;
import com.google.gson.Gson;

import java.io.FileReader;

public class GeneratorQuest {
    private String[] listaNomes;
    private String[] listaClasse;
    private String[] listaRank;
    private Quest[] listaQuests;
    private LocationMap[] listaLocations;


    public GeneratorQuest() {
        loadDataFromJson();
        loadLocationDataFromApi();
    }

    public Player generatePlayer() {
        String nome = listPicker(listaNomes);
        String classe = listPicker(listaClasse);
        String rank = listPicker(listaRank);
        Integer nivel = generatePlayerLevel(10, 70);
        Player player = new Player(nome, classe, rank, nivel, null);
        assignRandomQuest(player); // Atribuir uma quest aleatória ao jogador
        return player;
    }

    public static int generatePlayerLevel(int from, int to) {
        return (int) (from + (Math.random() * (to - from)));
    }

    public void assignRandomQuest(Player player) {
        Quest quest = pickRandomQuest();
        if (player.getNivel() >= quest.getNivel()) {
            player.setQuest(quest.getNome());
            LocationMap randomLocation = pickRandomLocation();
            System.out.println("O jogador " + player.getNome() + ", da classe " + player.getClasse() + ", nível " + player.getNivel() + ", rank " + player.getRank() + ", resgatou com sucesso a quest de Nível: "+quest.getNivel() + " " + quest.getNome());
            System.out.println("Sua Quest está localizada em " + randomLocation.getName() + " Na zona de ID " + randomLocation.getZoneCount());
        } else {
            System.out.println("Erro: O jogador " + player.getNome() + ", da classe " + player.getClasse() + ", nível " + player.getNivel() + ", rank " + player.getRank() + " não pode receber a quest '" + quest.getNome() + ", Nível da quest: " + quest.getNivel()+ "'! Nível abaixo do recomendado.");
        }
    }

    private LocationMap pickRandomLocation() {
        int randomIndex = (int) (Math.random() * listaLocations.length);
        return listaLocations[randomIndex];
    }

    public Quest pickRandomQuest() {
        int randomIndex = (int) (Math.random() * listaQuests.length);
        return listaQuests[randomIndex];
    }

    public String listPicker(String[] picker) {
        int randomIndex = (int) Math.floor(Math.random() * picker.length);
        return picker[randomIndex];
    }

    private void loadLocationDataFromApi() {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("C:\\Users\\Usuario\\Documents\\MMORPG\\src\\main\\java\\Api\\locations.json");
            LocationMap[] locations = gson.fromJson(reader, LocationMap[].class);
            this.listaLocations = locations;
            reader.close();
        } catch (Exception e) {
            System.out.println("Erro ao carregar dados de localização da API.");
            e.printStackTrace();
        }
    }

    private void loadDataFromJson() {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("C:\\Users\\Usuario\\Documents\\MMORPG\\src\\main\\java\\Projeto\\Rpg\\newPlayer.json");
            Data data = gson.fromJson(reader, Data.class);
            this.listaNomes = data.nomes;
            this.listaClasse = data.classes;
            this.listaRank = data.rank;
            this.listaQuests = data.quests;
            reader.close();
        } catch (Exception e) {
            System.out.println("Erro ao carregar dados do JSON.");
            e.printStackTrace();
        }
    }

    private static class Data {
        String[] nomes;
        String[] classes;
        String[] rank;
        Quest[] quests;
    }
    private static class Quest {
        String nome;
        int nivel;

        public String getNome() {
            return nome;
        }

        public int getNivel() {
            return nivel;
        }
    }
}
