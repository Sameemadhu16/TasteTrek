package com.zosh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Data
// @NoArgsConstructor
// @AllArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private User customer;

    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;

    private Long totalamount;

    private String orderstatus;

    private Date createdAt;

    @ManyToOne
    private Address deliveryaddress;

    @OneToMany
    private List<OrderItem> items;

//    private Payment payment;

    private int totalItem;

    private Long totalPrice;

}
