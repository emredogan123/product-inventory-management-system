public class Inventory {
    private Tree<Product> productTree;

    public Inventory() {
        productTree = new Tree<>();
    }

    public void addProduct(String name, String category, int price) {
        Product product = new Product(name, category, price);
        productTree.add(product);
        System.out.println("Adding: " + product);
    }

    public void searchProduct(String name) {
        for (Product product : productTree.list()) {
            if (product.getName().equals(name)) {
                System.out.println("Searching: Found: " + product);
                return;
            }
        }
        System.out.println("Searching: Not Found: " + name);
    }

    public void listProducts() {
        System.out.println("Listing:");
        for (Product product : productTree.list()) {
            System.out.println(product);
        }
    }
}
