package com.productmaintenace.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name ="code" , nullable = false)
    @NotBlank(message = "Please enter the code!")
    private String code;


    @Column(name = "description" , nullable = false)
    @NotBlank(message = "Please enter the description!")
    private String description;


    @Column(name = "price" , nullable = false)
    @DecimalMin(value = "0.1", message = "Invalid Price!")
    private double price;


    public Product(long id, String code, String description, double price) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public Product() {

    }
}
