package bg.softuni.mobilele.services.impl;

import bg.softuni.mobilele.models.entities.BrandEntity;
import bg.softuni.mobilele.models.views.ModelViewModel;
import bg.softuni.mobilele.repositories.ModelRepository;
import bg.softuni.mobilele.services.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ModelViewModel> findAllByBrand(BrandEntity brandEntity) {
        return this.modelRepository.findByBrand(brandEntity)
                .stream().map(model -> this.modelMapper.map(model, ModelViewModel.class))
                .collect(Collectors.toList());
    }

//    public String importAuthors() throws FileNotFoundException {
//        StringBuilder sb = new StringBuilder();
//        AuthorSeedDto[] dtos = this.gson.fromJson(new FileReader(GlobalConstants.AUTHORS_FILE_PATH), AuthorSeedDto[].class);
//
//        System.out.println();
//
//        for (AuthorSeedDto dto : dtos) {
//
//            Author author = this.authorRepository.findByFirstNameAndLastName(dto.getFirstName(), dto.getLastName());
//            if (this.validatorUtil.isValid(dto) && author == null) {
//
//                Author authorToImport = this.modelMapper.map(dto, Author.class);
//
//                this.authorRepository.saveAndFlush(authorToImport);
//                sb.append(String.format("Successfully imported Author: %s %s - %s",
//                        authorToImport.getFirstName(), authorToImport.getLastName(), authorToImport.getBirthTown()));
//
//            } else {
//                sb.append(String.format("Invalid Author: %s", dto.getFirstName() + " " + dto.getLastName()));
//            }
//
//            sb.append(System.lineSeparator());
//        }
//
//        return sb.toString();
//    }
}
