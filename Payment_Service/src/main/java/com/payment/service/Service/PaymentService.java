package com.payment.service.Service;

import com.payment.service.DTO.Order;
import com.payment.service.DTO.ResponseDTO;
import com.payment.service.Entity.Payment;
import com.payment.service.Exception.ResourceNotFoundException;
import com.payment.service.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;

    @Autowired
    private RestTemplate restTemplate;

    public void save(Payment payment) {
        paymentRepo.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    public Payment getPaymentsById(long id) {
        return paymentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Payment id does not exists"));
    }

    public void updatePaymentById(Payment payment, long id) {
        paymentRepo.save(payment);
        paymentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment id does not exists"));
    }

    public void deletePayment(long id) {
        paymentRepo.deleteById(id);
    }

    public ResponseDTO getPaymentByIdWithOrderDetails(long payment_id){
        Payment payment = paymentRepo.findById(payment_id).orElseThrow(() -> new ResourceNotFoundException("Payment id does not exists"));
        long orderId = payment.getOrder_id();

        Order order = restTemplate.getForObject("http://ORDERSERVICE/api/orders/getOrdersById/"+orderId, Order.class);

        ResponseDTO responseDto = new ResponseDTO();
        responseDto.setPayment(payment);
        responseDto.setOrder(order);

        return responseDto;
    }
}
