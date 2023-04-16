package dev.bozho.outfitmanagerserver.payload;

import dev.bozho.outfitmanagerserver.model.ItemType;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponse {

    private ItemType type;

    private String color;

    private String name;

    private String image;

    private String dateAdded;

    private String dateLastWorn;

    public ItemResponse(ItemType type, String color, String name, String dateAdded, String dateLastWorn) {
        this.type = type;
        this.color = color;
        this.name = name;
        this.dateAdded = dateAdded;
        this.dateLastWorn = dateLastWorn;
    }

}
