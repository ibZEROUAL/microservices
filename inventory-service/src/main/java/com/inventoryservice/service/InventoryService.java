package com.inventoryservice.service;

import com.inventoryservice.dto.InventoryDto;
import com.inventoryservice.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public List<InventoryDto> isInStock(List<String> skuCodes){
       return inventoryRepository.findBySkuCodeIn(skuCodes).parallelStream()
               .map(inventory -> new InventoryDto(inventory.getSkuCode(),inventory.getQuantity() > 0))
               .toList();
    }

}
