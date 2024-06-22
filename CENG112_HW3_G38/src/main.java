public class main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        FileIO.processFile("src//products.csv", inventory);
    }
}
