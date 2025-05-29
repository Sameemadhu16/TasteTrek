package com.zosh.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {
    private String title;

    @Column(length = 1000)

    private List<String> images;

    private String description;
    private long id;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
