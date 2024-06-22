public class Product implements Comparable<Product> {
    private String name;
    private String category;
    private int price;

    public Product(String name, String category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product other) {
        int categoryComparison = this.category.compareTo(other.category);
        if (categoryComparison == 0) {
            return this.name.compareTo(other.name);
        }
        return categoryComparison;
    }

    @Override
    public String toString() {
        return String.format("%s (%s): %d₺", name, category, price);
    }
}
