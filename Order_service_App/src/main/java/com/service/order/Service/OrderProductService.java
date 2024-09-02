package com.service.order.Service;

import com.service.order.DTO.Product;
import com.service.order.DTO.ResponseDTO;
import com.service.order.Entity.Order;
import com.service.order.Exception.ResourceNotFoundException;
import com.service.order.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class OrderProductService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private RestTemplate restTemplate;

    public void save(Order orderProduct) {
        orderRepo.save(orderProduct);
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Order getOrdersById(long id) {
        return orderRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order id does not exists"));
    }

    public void updateOrders(Order orderProduct, long id) {
        orderRepo.save(orderProduct);
        orderRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order id does not exists"));
    }

    public void deleteOrderById(long id) {
        orderRepo.deleteById(id);
    }

    public ResponseDTO getOrderByIdWithProductDetails(long order_Id){
        Order order = orderRepo.findById(order_Id).orElseThrow(() -> new ResourceNotFoundException("Order id does not exists"));
        long productId = order.getProductId();

        Product product = restTemplate.getForObject("http://PRODUCTSERVICE/api/products/getProductById/"+productId, Product.class);

        ResponseDTO responseDto = new ResponseDTO();
        responseDto.setOrder(order);
        responseDto.setProduct(product);

        return responseDto;
    }
}
