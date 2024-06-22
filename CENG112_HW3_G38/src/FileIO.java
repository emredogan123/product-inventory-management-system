import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
    public static void processFile(String filename, Inventory inventory) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                processLine(line, inventory);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processLine(String line, Inventory inventory) {
        String[] parts = line.split(",");
        String command = parts[0];
        switch (command) {
            case "add":
                String category = parts[1];
                String name = parts[2];
                int price = Integer.parseInt(parts[3]);
                inventory.addProduct(name, category, price);
                break;
            case "search":
                name = parts[1];
                inventory.searchProduct(name);
                break;
            case "list":
                inventory.listProducts();
                break;
        }
    }
}
