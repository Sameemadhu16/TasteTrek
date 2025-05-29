package com.zosh.request;

import java.util.List;

import com.zosh.model.Category;
import com.zosh.model.IngrediantsItem;

import lombok.Data;

@Data
public class CreateFoodRequest {

    private String name;
    private String description;
    private Long price;

    private Category category;
    private List<String> images;

    private Long restaurantId;
    private boolean vegetarin;
    private boolean seasional;
    private List<IngrediantsItem> ingredients;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getPrice() {
        return price;
    }

    public List<String> getImages() {
        return images;
    }

    public List<IngrediantsItem> getIngredients() {
        return ingredients;
    }

    public boolean isSeasional() {
        return seasional;
    }

    public boolean isvegtarain() {
        return vegetarin;
    }

}
