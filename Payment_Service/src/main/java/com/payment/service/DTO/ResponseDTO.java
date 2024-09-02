package com.payment.service.DTO;

import com.payment.service.Entity.Payment;
import lombok.Data;

@Data
public class ResponseDTO {

    private Payment payment;
    private Order order;
}
