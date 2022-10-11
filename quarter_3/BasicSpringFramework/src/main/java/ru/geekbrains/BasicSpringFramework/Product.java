package ru.geekbrains.BasicSpringFramework;

public class Product {

    private Integer id;

    private String title;

    private long price;

    public Product() {
    }

    public Product(int id, String title, long price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
