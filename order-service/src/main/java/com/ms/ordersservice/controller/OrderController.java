package com.ms.ordersservice.controller;

import com.ms.ordersservice.dto.OrderDto;
import com.ms.ordersservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderDto orderDto) {
        orderService.placeOrder(orderDto);
        return new ResponseEntity<>("Order Placed Successfully", HttpStatus.CREATED);
    }

}
