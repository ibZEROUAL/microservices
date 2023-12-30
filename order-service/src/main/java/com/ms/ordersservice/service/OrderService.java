package com.ms.ordersservice.service;

import com.ms.ordersservice.dto.InventoryDto;
import com.ms.ordersservice.dto.OrderDto;
import com.ms.ordersservice.mapper.OrderLineItemsMapper;
import com.ms.ordersservice.mapper.OrderMapper;
import com.ms.ordersservice.model.Order;
import com.ms.ordersservice.model.OrderLineItems;
import com.ms.ordersservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    private final OrderLineItemsService orderLineItemsService;

    private final OrderLineItemsMapper orderLineItemsMapper;

    private final WebClient webClient;

    public void placeOrder(OrderDto orderDto){

        Order order = orderMapper.orderDtoToOrder(orderDto);
        order.setOrderLineItems(orderLineItemsMapper.orderLineItemsDtoListToOrderLineItemsList(orderDto.getOrderLineItemsDtos()));

        order.getOrderLineItems().forEach(orderLineItems -> {
            orderLineItemsService.saveOrderLineItem(orderLineItems);
            orderLineItems.setOrder(order);
        });

        order.setOrderNumber("order".concat(UUID.randomUUID().toString()));

        List<String> skuCodes = order.getOrderLineItems().parallelStream().map(OrderLineItems::getSkuCode).toList();

        // request data to inventory-service using webClient instead of restTemplate
        InventoryDto[] inventoryDtos = webClient.get()
                .uri("http://localhost:8082/api/inventory/pc",
                        uriBuilder -> uriBuilder.queryParam("skuCodes",skuCodes).build())
                .retrieve().bodyToMono(InventoryDto[].class).block();

        boolean isAllProductsInStock = Arrays.stream(inventoryDtos).allMatch(InventoryDto::isInStock);

        if (isAllProductsInStock){
            orderRepository.save(order);
        }else {
            throw new IllegalArgumentException("product is out of stock !!");
        }
    }
    public List<OrderDto> getOrders(){

       return orderRepository.findAll().parallelStream()
                .map(order -> {
                   var orderLineItemsListDtos = orderLineItemsService.getOrderLineItemsByOrderNumber(order.getId());
                   var orderDto = orderMapper.orderToOrderDto(order);
                   orderDto.setOrderLineItemsDtos(orderLineItemsListDtos);
                   return orderDto;
                }).toList();
    }

}
