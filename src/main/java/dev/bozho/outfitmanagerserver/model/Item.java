package dev.bozho.outfitmanagerserver.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
    private ItemImage image;

    @Nonnull
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dateAdded = LocalDateTime.now();

    private LocalDateTime dateLastWorn;

    @ManyToMany()
    private Set<Outfit> outfits = new HashSet<>();

    public Item(@Nonnull ItemType type, @Nonnull Color color, @Nonnull String name) {
        this.type = type;
        this.color = color;
        this.name = name;
    }

}
