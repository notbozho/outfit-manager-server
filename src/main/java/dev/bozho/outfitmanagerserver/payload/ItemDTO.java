package dev.bozho.outfitmanagerserver.payload;

import dev.bozho.outfitmanagerserver.model.Color;
import dev.bozho.outfitmanagerserver.model.ItemType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    @NonNull
    public ItemType type;

    @NonNull
    public Color color;

    @NonNull
    public String name;

}
