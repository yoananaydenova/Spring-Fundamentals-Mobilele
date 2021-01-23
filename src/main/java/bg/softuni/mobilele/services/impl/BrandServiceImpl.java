package bg.softuni.mobilele.services.impl;

import bg.softuni.mobilele.models.views.BrandViewModel;
import bg.softuni.mobilele.repositories.BrandRepository;
import bg.softuni.mobilele.services.BrandService;
import bg.softuni.mobilele.services.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelService modelService;
    private final ModelMapper modelMapper;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, ModelService modelService, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelService = modelService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
       return this.brandRepository.findAll()
               .stream().map(brandEntity -> {
                   BrandViewModel brandViewModel = this.modelMapper
                           .map(brandEntity, BrandViewModel.class);
                   brandViewModel.setModels(this.modelService.findAllByBrand(brandEntity));
                   return brandViewModel;
               })
               .collect(Collectors.toList());
    }
}
