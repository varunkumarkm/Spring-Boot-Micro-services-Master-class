package com.product.service.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long productId;
    public String name;
    public int quantity;
    public int price;

}
