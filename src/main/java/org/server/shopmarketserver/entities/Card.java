package org.server.shopmarketserver.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "MARKET")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String img;
    @Column(nullable = false)
    private String releaseDate;
    @Column(nullable = false)
    private int cost;
    @Column(nullable = false)
    private int quantity;



    public Card(){

    }

    public Card(String name, String img, String releaseDate, int cost,int quantity) {
        this.name = name;
        this.img = img;
        this.releaseDate = releaseDate;
        this.cost = cost;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", cost=" + cost +
                ", quantity=" + quantity +
                '}';
    }
}