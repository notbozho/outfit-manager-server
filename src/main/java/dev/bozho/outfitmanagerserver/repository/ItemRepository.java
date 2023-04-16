package dev.bozho.outfitmanagerserver.repository;

import dev.bozho.outfitmanagerserver.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
