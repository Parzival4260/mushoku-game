package save;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;

public class SaveManager {

    private static final String FILE = "save.json";

    public static void saveGame(SaveData data) {

        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter writer = new FileWriter(FILE);
            gson.toJson(data, writer);
            writer.close();
            System.out.println("Partida guardada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SaveData loadGame() {

        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(FILE);
            SaveData data = gson.fromJson(reader, SaveData.class);
            reader.close();
            return data;
        } catch (Exception e) {
            System.out.println("No hay partida guardada.");
            return null;
        }
    }
}
