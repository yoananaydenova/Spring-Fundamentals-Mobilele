package bg.softuni.mobilele.services;

import bg.softuni.mobilele.models.entities.BrandEntity;
import bg.softuni.mobilele.models.views.ModelViewModel;

import java.util.List;

public interface ModelService {
    List<ModelViewModel> findAllByBrand(BrandEntity brandEntity);
}
