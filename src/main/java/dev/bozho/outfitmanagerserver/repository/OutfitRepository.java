package dev.bozho.outfitmanagerserver.repository;

import dev.bozho.outfitmanagerserver.model.Outfit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutfitRepository extends JpaRepository<Outfit, Long> {

}
