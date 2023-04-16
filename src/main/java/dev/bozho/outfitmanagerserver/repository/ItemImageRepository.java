package dev.bozho.outfitmanagerserver.repository;

import dev.bozho.outfitmanagerserver.model.ItemImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemImageRepository extends JpaRepository<ItemImage, String> {
}
