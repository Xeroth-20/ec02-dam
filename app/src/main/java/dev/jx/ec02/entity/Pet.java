package dev.jx.ec02.entity;

import java.util.List;

public class Pet {

    private int id;
    private String name;
    private String animal;
    private String breed;
    private String state;
    private String city;
    private String description;
    private List<String> images;

    public Pet(int id, String name, String animal, String breed, String state, String city, String description, List<String> images) {
        this.id = id;
        this.name = name;
        this.animal = animal;
        this.breed = breed;
        this.state = state;
        this.city = city;
        this.description = description;
        this.images = images;
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

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
