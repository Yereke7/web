package com.example.web.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "p_name")
    private String name;

    @Column(name = "count")
    private int count;

    @Column(name = "p_type")
    private String type;

    @Column(name = "price")
    private int price;
}
