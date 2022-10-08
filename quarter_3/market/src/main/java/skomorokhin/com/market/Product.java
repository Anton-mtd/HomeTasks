package skomorokhin.com.market;


public class Product {

    private int id;

    private int price;

    private String name;

    public Product(int id, int price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", cost=" + price +
                ", title='" + name + '\'' +
                '}';
    }
}
