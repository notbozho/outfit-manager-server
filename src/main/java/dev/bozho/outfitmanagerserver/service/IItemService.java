package dev.bozho.outfitmanagerserver.service;

import dev.bozho.outfitmanagerserver.model.Item;
import dev.bozho.outfitmanagerserver.payload.ItemDto;
import dev.bozho.outfitmanagerserver.payload.ItemResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IItemService {

    List<ItemResponse> getAllItems();

    Item getItemById(Long id);

    ItemResponse createItem(ItemDto item, MultipartFile imageFile);

    void deleteItem(Long id);
}
