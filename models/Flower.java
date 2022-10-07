package com.lab.FlowerLand.tour;

import javax.persistence.*;

@Entity
@Table
public class Flower {
    @Id
    @SequenceGenerator(
            name = "flower_sequence",
            sequenceName = "flower_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "flower_sequence"
    )
    private Long id;
    private String name;

    private Integer price;
    private String image;

    public Flower() {
    }

    public Flower(Long id, String name, Integer price, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public Flower(String name, Integer price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + id +
                ", name='" + name + ''' +
        ", price=" + price +
                ", image='" + image + ''' +
        '}';
    }
}