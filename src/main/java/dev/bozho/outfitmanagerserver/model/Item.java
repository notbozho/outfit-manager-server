package dev.bozho.outfitmanagerserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private ItemType type;

    @Enumerated(EnumType.STRING)
    private Color color;

    private String name;

    @Lob
    private String image;

    private LocalDateTime dateAdded = LocalDateTime.now();

    private LocalDateTime dateLastWorn;

    @ManyToMany()
    private Set<Outfit> outfits = new HashSet<>();

    public Item(ItemType type, Color color, String name) {
        this.type = type;
        this.color = color;
        this.name = name;
    }

}
