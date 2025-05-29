package com.zosh.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
// @NoArgsConstructor
// @AllArgsConstructor
@Getter
@Setter
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String description;
    private Long price;

    @ManyToOne
    private Category foodcategory;

    @ElementCollection
    @Column(length = 1000)
    private List<String> images;

    private boolean available;

    @ManyToOne
    private Restaurant restaurant;

    private boolean isVegetarian;
    private boolean isSeasonal;

    @ManyToMany
    private List<IngrediantsItem> ingrediants = new ArrayList<>();

    private Date creationalDate;

    public void setFoodcategory(Category foodcategory) {
        this.foodcategory = foodcategory;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setIngrediants(List<IngrediantsItem> ingrediants) {
        this.ingrediants = ingrediants;
    }

    public void setSeasonal(boolean isSeasonal) {
        this.isSeasonal = isSeasonal;
    }

    public void setVegetarian(boolean isVegetarian) {
        this.isVegetarian = isVegetarian;
    }
}
