package com.ms.ordersservice.mapper;

import com.ms.ordersservice.dto.OrderDto;
import com.ms.ordersservice.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderDto orderToOrderDto(Order order);

    Order orderDtoToOrder(OrderDto orderDto);

    List<Order> orderDtoListToOrderList(List<OrderDto> orderDtoList);

    List<OrderDto> orderListToOrderDtoList(List<Order> orderList);

}
