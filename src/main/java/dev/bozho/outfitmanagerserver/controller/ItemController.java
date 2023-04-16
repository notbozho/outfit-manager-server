package dev.bozho.outfitmanagerserver.controller;

import dev.bozho.outfitmanagerserver.model.Item;
import dev.bozho.outfitmanagerserver.payload.ItemDTO;
import dev.bozho.outfitmanagerserver.service.impl.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping(value = "/create")
    public ResponseEntity<Item> createItem(@RequestPart("item") ItemDTO item, @RequestPart("image") MultipartFile imageFile) {
        System.out.println(item.toString());
        Item createdItem = itemService.createItem(item, imageFile);
        return ResponseEntity.ok(createdItem);
    }

}
