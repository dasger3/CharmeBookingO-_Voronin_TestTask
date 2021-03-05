package BackToStock;

public class Product {

    private final String id;
    private final ProductCategory category;
    private MyQueue<User> queue;

    public Product(String id, ProductCategory category) {
        this.id = id;
        this.category = category;
        queue = new MyQueue<User>(category);
    }

    public String getId() {
        return id;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public MyQueue<User> getQueue() {
        return queue;
    }



}
