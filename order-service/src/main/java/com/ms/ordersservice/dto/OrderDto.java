package com.ms.ordersservice.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private List<OrderLineItemsDto> orderLineItemsDtos;

}
