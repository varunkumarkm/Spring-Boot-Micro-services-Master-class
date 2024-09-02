package com.service.order.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long order_Id;

    public String customer_Name;
    public String email;
    public long productId;
    public int total_price;
    public String address;

}
