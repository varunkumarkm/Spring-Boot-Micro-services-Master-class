package com.service.order.DTO;

import lombok.Data;

@Data
public class Product {

    public long productId;
    public String name;
    public int quantity;
    public int price;
}
