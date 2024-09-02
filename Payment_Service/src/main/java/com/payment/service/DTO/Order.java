package com.payment.service.DTO;

import lombok.Data;

@Data
public class Order {

    public long order_Id;
    public String customer_Name;
    public String email;
    public long productId;
    public int total_price;
    public String address;
}
