package com.example.benguerirfood.services.ui.restaurants.menuPizza;

public class IteamsPizza {
    String namee,pricee,discreption,caloriess;
    int photo;

    public IteamsPizza(String namee, String pricee, String discreption, String caloriess, int photo) {
        this.namee = namee;
        this.pricee = pricee;
        this.discreption = discreption;
        this.caloriess = caloriess;
        this.photo = photo;
    }

    public IteamsPizza() {
    }

    public String getNamee() {
        return namee;
    }

    public void setNamee(String namee) {
        this.namee = namee;
    }

    public String getPricee() {
        return pricee;
    }

    public void setPricee(String pricee) {
        this.pricee = pricee;
    }

    public String getDiscreption() {
        return discreption;
    }

    public void setDiscreption(String discreption) {
        this.discreption = discreption;
    }

    public String getCaloriess() {
        return caloriess;
    }

    public void setCaloriess(String caloriess) {
        this.caloriess = caloriess;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
