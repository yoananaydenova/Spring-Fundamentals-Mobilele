package bg.softuni.mobilele.repositories;


import bg.softuni.mobilele.models.entities.BrandEntity;
import bg.softuni.mobilele.models.entities.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {

    List<ModelEntity> findByBrand(BrandEntity brandEntity);
}
