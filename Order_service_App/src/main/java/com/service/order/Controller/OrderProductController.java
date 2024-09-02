package com.service.order.Controller;

import com.service.order.DTO.ResponseDTO;
import com.service.order.Entity.Order;
import com.service.order.Service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderProductController {

    @Autowired
    private OrderProductService orderService;

    @PostMapping("/creteOrder")
    public ResponseEntity<Order> createOrderProduct(@RequestBody Order order){
        orderService.save(order);
        return new ResponseEntity<Order>(order, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/getOrdersById/{id}")
    public Order getOrdersById (@PathVariable long id){
        return orderService.getOrdersById(id);
    }

    @PutMapping("/updateProductById/{id}")
    public ResponseEntity<Order> updateOrders(@RequestBody Order order, @PathVariable long id){
        orderService.updateOrders(order, id);
        return new ResponseEntity<Order>(order, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteOrderById/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable long id){
        orderService.deleteOrderById(id);
        return new ResponseEntity<>("Order deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseDTO getOrderByIdWithProductDetails (@PathVariable long id){
      return orderService.getOrderByIdWithProductDetails(id);
    }
}
