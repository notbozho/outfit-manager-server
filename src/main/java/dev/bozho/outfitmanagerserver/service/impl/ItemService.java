package dev.bozho.outfitmanagerserver.service.impl;

import dev.bozho.outfitmanagerserver.model.Item;
import dev.bozho.outfitmanagerserver.payload.ItemDto;
import dev.bozho.outfitmanagerserver.payload.ItemResponse;
import dev.bozho.outfitmanagerserver.repository.ItemRepository;
import dev.bozho.outfitmanagerserver.service.IItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService implements IItemService {

    private final ItemRepository itemRepository;

    private final ModelMapper modelMapper;

    public List<ItemResponse> getAllItems() {
        List<Item> items = itemRepository.findAll();

        return modelMapper.map(items, List.class);
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public ItemResponse createItem(ItemDto itemDTO, MultipartFile imageFile) {
        Item item  = modelMapper.map(itemDTO, Item.class);

        try {

            String base64Image = convertToBase64(imageFile.getBytes());
            item.setImage(base64Image);

            itemRepository.save(item);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return modelMapper.map(item, ItemResponse.class);
    }

    @Override
    public void deleteItem(Long id) {
            itemRepository.deleteById(id);
    }

    private static String convertToBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

}
