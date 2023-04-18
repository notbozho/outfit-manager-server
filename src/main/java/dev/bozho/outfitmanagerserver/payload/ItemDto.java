package dev.bozho.outfitmanagerserver.payload;

import dev.bozho.outfitmanagerserver.model.Color;
import dev.bozho.outfitmanagerserver.model.ItemType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    private long id;

    @NotNull
    private ItemType type;

    @NotNull
    private Color color;

    @NotNull
    private String name;

    private boolean favorite;

    public ItemDto(ItemType type, Color color, String name, boolean favorite) {
        this.type = type;
        this.color = color;
        this.name = name;
        this.favorite = favorite;
    }

}
