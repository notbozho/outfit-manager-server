package dev.bozho.outfitmanagerserver.payload;

import dev.bozho.outfitmanagerserver.model.Color;
import dev.bozho.outfitmanagerserver.model.ItemType;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponse {

    private long id;

    private ItemType type;

    private Color color;

    private String name;

    private String image;

    private String dateAdded;

    private String dateLastWorn;

    private boolean favorite;

    public ItemResponse(ItemType type, Color color, String name) {
        this.type = type;
        this.color = color;
        this.name = name;
    }

    public ItemResponse(ItemType type, Color color, String name, boolean favorite) {
        this.type = type;
        this.color = color;
        this.name = name;
        this.favorite = favorite;
    }

    public ItemResponse(Long id, ItemType type, Color color, String name, String image, boolean favorite) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.name = name;
        this.image = image;
        this.favorite = favorite;
    }

    public ItemResponse(ItemType type, Color color, String name, String dateAdded, String dateLastWorn, boolean favorite) {
        this.type = type;
        this.color = color;
        this.name = name;
        this.dateAdded = dateAdded;
        this.dateLastWorn = dateLastWorn;
        this.favorite = favorite;
    }

}
