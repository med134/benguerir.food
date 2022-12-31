package com.example.benguerirfood.services.ui.boulangier.menuIteams.menuPain;

public class IteamsPain {
    String name,price,discription,calories;
    int image;

    public IteamsPain(String name, String price, String discription, String calories, int image) {
        this.name = name;
        this.price = price;
        this.discription = discription;
        this.calories = calories;
        this.image = image;
    }
    public IteamsPain (){

    }
    public IteamsPain(String name,String discription,int image){
        this.name = name;
        this.discription = discription;
        this.image = image;
    }
    public IteamsPain (String name,String disc){
        this.name= name;
        this.discription=disc;
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

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }
}
