package com.imran.demoapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
    private @Id @GeneratedValue Integer id;
    private String name;
    private String description;
    private String price;

    public Product() {}

    public Product(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;
        Product p = (Product) o;
        return Objects.equals(this.id, p.id) &&
                Objects.equals(this.name, p.name) &&
                Objects.equals(this.description, p.description) &&
                Objects.equals(this.price, p.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.description, this.price);
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", description='" + this.description + '\'' +
                ", price='" + this.price + '\'' + '}';
    }
}
