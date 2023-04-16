package dev.bozho.outfitmanagerserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Outfit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private String image;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "outfits")
    private Set<Item> items = new HashSet<>();
}
