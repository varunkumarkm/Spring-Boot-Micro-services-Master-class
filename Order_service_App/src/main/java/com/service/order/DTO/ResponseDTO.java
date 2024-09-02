package com.service.order.DTO;

import com.service.order.Entity.Order;
import lombok.Data;

@Data
public class ResponseDTO {

    private Order order;
    private Product product;
}
