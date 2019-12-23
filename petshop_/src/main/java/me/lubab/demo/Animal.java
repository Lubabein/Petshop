package me.lubab.demo;

import javax.persistence.*;


@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 64)
    private String name;
    @Column(name= "kind", length = 32)
    private String kind;
    @Column(name="price", length = 16, precision = 10, scale = 2)
    private int price;

    public Animal() {
        super();
    }

    public Animal(int id, String name, String kind, int price) {
        super();
        this.id=id;
        this.name = name;
        this.kind = kind;
        this.price = price;
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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
