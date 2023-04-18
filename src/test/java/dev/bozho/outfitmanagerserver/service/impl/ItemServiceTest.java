package dev.bozho.outfitmanagerserver.service.impl;

import dev.bozho.outfitmanagerserver.model.Color;
import dev.bozho.outfitmanagerserver.model.Item;
import dev.bozho.outfitmanagerserver.model.ItemType;
import dev.bozho.outfitmanagerserver.payload.ItemDto;
import dev.bozho.outfitmanagerserver.payload.ItemResponse;
import dev.bozho.outfitmanagerserver.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.mock.web.MockMultipartFile;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ItemService itemService;

    @Test
    void getAllItems_returnsListOfItemResponses() {
        // Arrange
        List<Item> items = new ArrayList<>();

        items.add(new Item(1L, ItemType.HOODIE, Color.BLACK, "test hoodie", "base64Image", false));
        items.add(new Item(2L, ItemType.TSHIRT, Color.BLUE, "test tshirt", "base64Image", false));
        when(itemRepository.findAll()).thenReturn(items);

        List<ItemResponse> itemResponses = new ArrayList<>();
        itemResponses.add(new ItemResponse(1L, ItemType.HOODIE, Color.BLACK, "test hoodie", "base64Image", false));
        itemResponses.add(new ItemResponse(2L, ItemType.TSHIRT, Color.BLUE, "test tshirt", "base64Image", false));
        when(modelMapper.map(items, List.class)).thenReturn(itemResponses);

        // Act
        List<ItemResponse> result = itemService.getAllItems();

        // Assert
        Assertions.assertNotNull(result, "result is null");
        Assertions.assertEquals(itemResponses, result, "result is not equal to expected itemResponses");
        Assertions.assertEquals(2, result.size(), "result size is not equal to expected size");
        Assertions.assertEquals(1L, result.get(0).getId(), "first result id is not equal to expected id");

        verify(itemRepository, times(1)).findAll();
        verify(modelMapper, times(1)).map(items, List.class);
    }

    @Test
    void getItemById() {
    }

    @Test
    void createItem_returnsItemResponse() {
        // Arrange
        ItemDto itemDto = new ItemDto(ItemType.HOODIE, Color.BLACK, "test hoodie", false);

        MockMultipartFile imageFile = new MockMultipartFile("image", "test.png", "image/png",
                "test hoodie image".getBytes());

        Item item = new Item(1L, ItemType.HOODIE, Color.BLACK, "test hoodie", "base64Image", false);

        ItemResponse expectedResponse = new ItemResponse(ItemType.HOODIE, Color.BLACK, "test hoodie", false);

        when(modelMapper.map(eq(itemDto), eq(Item.class))).thenReturn(item);
        when(itemRepository.save(any(Item.class))).thenReturn(item);
        when(modelMapper.map(eq(item), eq(ItemResponse.class))).thenReturn(expectedResponse);

        // Act
        var actualResponse = itemService.createItem(itemDto, imageFile);


        // Assert
        Assertions.assertNotNull(actualResponse, "actualResponse is null");
        Assertions.assertInstanceOf(ItemResponse.class, actualResponse, "actualResponse is not an instance of ItemResponse");
        Assertions.assertEquals(expectedResponse.getId(), actualResponse.getId(), "actualResponse id is not equal to expectedResponse id");
        Assertions.assertEquals(expectedResponse.getName(), actualResponse.getName(), "actualResponse name is not equal to expectedResponse name");

        verify(itemRepository, times(1)).save(item);
        verify(modelMapper, times(1)).map(itemDto, Item.class);
    }

    @Test
    void deleteItem_deletesItemById() {
        // Arrange
        Long id = 1L;
        doNothing().when(itemRepository).deleteById(id);

        // Act
        itemService.deleteItem(id);

        // Assert
        Assertions.assertDoesNotThrow(() -> itemService.deleteItem(id), "deleteItem throws an exception");

        verify(itemRepository, times(2)).deleteById(id);
    }

}