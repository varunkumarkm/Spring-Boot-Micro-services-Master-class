package com.payment.service.Controller;

import com.payment.service.DTO.ResponseDTO;
import com.payment.service.Entity.Payment;
import com.payment.service.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/savePayment")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        paymentService.save(payment);
        return new ResponseEntity<Payment>(payment, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAllPayments")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/getPaymentById/{id}")
    public Payment getPaymentById(@PathVariable long id) {
       return paymentService.getPaymentsById(id);
    }

    @PutMapping("/updatePayments/{id}")
    public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment, @PathVariable long id) {
        paymentService.updatePaymentById(payment, id);
        return new ResponseEntity<Payment>(payment, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deletePayment/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable long id){
        paymentService.deletePayment(id);
        return new ResponseEntity<>("Payment deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseDTO getPaymentByIdWithOrderDetails(@PathVariable long id){
        return paymentService.getPaymentByIdWithOrderDetails(id);
    }
}
