package dev.bozho.outfitmanagerserver.controller;

import dev.bozho.outfitmanagerserver.payload.ItemDto;
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
    public ResponseEntity<ItemResponse> createItem(@RequestPart("item") ItemDto item, @RequestPart("image") MultipartFile imageFile) {
        ItemResponse createdItem = itemService.createItem(item, imageFile);

        return ResponseEntity.ok(createdItem);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ItemResponse>> getAllItems() {
        List<ItemResponse> items = itemService.getAllItems();

        return ResponseEntity.ok(items);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);

        return ResponseEntity.ok(String.format("Item with id %d deleted successfully", id));
    }
}
