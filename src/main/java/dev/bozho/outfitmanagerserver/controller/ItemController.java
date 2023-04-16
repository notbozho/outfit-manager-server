package dev.bozho.outfitmanagerserver.controller;

import dev.bozho.outfitmanagerserver.model.Item;
import dev.bozho.outfitmanagerserver.payload.ItemDTO;
import dev.bozho.outfitmanagerserver.payload.ItemResponse;
import dev.bozho.outfitmanagerserver.service.impl.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping(value = "/create")
    public ResponseEntity<Item> createItem(@RequestPart("item") ItemDTO item, @RequestPart("image") MultipartFile imageFile) {
        Item createdItem = itemService.createItem(item, imageFile);

        System.out.println(createdItem.toString());

        return ResponseEntity.ok(createdItem);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ItemResponse>> getAllItems() {
        List<ItemResponse> items = itemService.getAllItems();

        return ResponseEntity.ok(items);
    }

}
