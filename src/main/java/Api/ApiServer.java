package Api;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiServer {

    private static final String MapJson = "C:\\Users\\Usuario\\Documents\\MMORPG\\src\\main\\java\\Api\\/locations.json";

    public static void main(String[] args) {
        try {
            URL url = new URL("https://mhw-db.com/locations");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            con.disconnect();

            // Salvar o JSON em um arquivo
            saveJsonToFile(response.toString());

            // Imprimir o JSON obtido da requisição
            System.out.println("JSON da API: ");
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveJsonToFile(String json) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MapJson))) {
            writer.write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
