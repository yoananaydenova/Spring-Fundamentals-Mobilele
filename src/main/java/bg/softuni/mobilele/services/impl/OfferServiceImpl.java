package bg.softuni.mobilele.services.impl;

import bg.softuni.mobilele.models.entities.OfferEntity;
import bg.softuni.mobilele.models.services.OfferServiceModel;
import bg.softuni.mobilele.models.views.OfferSummaryViewModel;
import bg.softuni.mobilele.repositories.ModelRepository;
import bg.softuni.mobilele.repositories.OfferRepository;
import bg.softuni.mobilele.repositories.UserRepository;
import bg.softuni.mobilele.security.CurrentUser;
import bg.softuni.mobilele.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, UserRepository userRepository, ModelRepository modelRepository, CurrentUser currentUser, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OfferSummaryViewModel> getAllOffers() {
        // TODO - implement mapping
        throw new UnsupportedOperationException("Upcoming soon :)");
    }

    @Override
    public Long save(OfferServiceModel offerServiceModel) {
        OfferEntity offerEntity = asNewEntity(offerServiceModel);

        OfferEntity newEntity = offerRepository.save(offerEntity);
        return newEntity.getId();
    }

    private OfferEntity asNewEntity(OfferServiceModel offerServiceModel) {
        OfferEntity offerEntity = new OfferEntity();
        modelMapper.map(offerServiceModel, offerEntity);

        offerEntity.setId(null);
        offerEntity.setModel(modelRepository.findById(offerServiceModel.getModelId()).orElseThrow());
        offerEntity.setSeller(userRepository.findByUsername(currentUser.getName()).orElseThrow());

        return offerEntity;
    }


}
