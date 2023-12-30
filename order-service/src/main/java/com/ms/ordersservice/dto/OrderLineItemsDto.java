package com.ms.ordersservice.dto;

import com.ms.ordersservice.model.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDto {

    private String skuCode;

    private BigDecimal price;

    private Integer quantity;

    private Order order;

}
