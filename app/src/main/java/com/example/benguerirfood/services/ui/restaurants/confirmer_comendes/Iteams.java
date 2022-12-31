package com.example.benguerirfood.services.ui.restaurants.confirmer_comendes;

import java.io.Serializable;

public class Iteams implements Serializable {
    String contité,name,price;
    int numbrCart;
    String image;


    public Iteams(String name,String price, String contité, String image) {
        this.contité = contité;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public int getNumbrCart() {
        return numbrCart;
    }

    public void setNumbrCart(int numbrCart) {
        this.numbrCart = numbrCart;
    }

    public String getContité() {
        return contité;
    }

    public void setContité(String contité) {
        this.contité = contité;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
