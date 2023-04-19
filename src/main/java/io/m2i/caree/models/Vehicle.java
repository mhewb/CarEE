package io.m2i.caree.models;

public class Vehicle {

    private int id;
    private String name;
    private Category category;
    private float price;
    private String description;
    private String imgUrl;

    public Vehicle(int id, String name, Category category, float price, String description, String imgUrl) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public Vehicle(String name, Category category, float price, String description, String imgUrl) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
