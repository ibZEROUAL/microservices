package com.inventoryservice.controller;

import com.inventoryservice.dto.InventoryDto;
import com.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@AllArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<List<InventoryDto>> isInStock(@RequestParam List<String> skuCodes){
        var isPresentInStock = inventoryService.isInStock(skuCodes);
        return new ResponseEntity<>(isPresentInStock, HttpStatus.OK);
    }

}
