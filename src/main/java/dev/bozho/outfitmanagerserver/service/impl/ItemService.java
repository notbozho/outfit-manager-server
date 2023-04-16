package dev.bozho.outfitmanagerserver.service.impl;

import dev.bozho.outfitmanagerserver.model.Item;
import dev.bozho.outfitmanagerserver.model.ItemImage;
import dev.bozho.outfitmanagerserver.payload.ItemDTO;
import dev.bozho.outfitmanagerserver.repository.ItemImageRepository;
import dev.bozho.outfitmanagerserver.repository.ItemRepository;
import dev.bozho.outfitmanagerserver.service.IItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService implements IItemService {

    private final ItemRepository itemRepository;

    private final ItemImageRepository itemImageRepository;

    private final ModelMapper modelMapper;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        return null;
    }

    @Override
    public Item createItem(ItemDTO itemDTO, MultipartFile imageFile) {
            Item item  = modelMapper.map(itemDTO, Item.class);
        try {

            ItemImage itemImage = new ItemImage();
            itemImage.setData(imageFile.getBytes());
            itemImage.setFileName(imageFile.getOriginalFilename());
            itemImage.setMimeType(imageFile.getContentType());
            itemImage.setItem(item);
            item.setImage(itemImage);

            itemRepository.save(item);

            itemImageRepository.save(itemImage);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return item;
    }

}
