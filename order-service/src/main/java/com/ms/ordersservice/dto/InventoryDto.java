package com.ms.ordersservice.dto;

import java.io.Serializable;
public record InventoryDto(String skuCode, Boolean isInStock) implements Serializable {}
