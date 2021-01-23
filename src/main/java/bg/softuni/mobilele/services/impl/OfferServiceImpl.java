package bg.softuni.mobilele.services.impl;

import bg.softuni.mobilele.models.views.OfferSummaryViewModel;
import bg.softuni.mobilele.repositories.OfferRepository;
import bg.softuni.mobilele.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.NotSupportedException;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OfferSummaryViewModel> getAllOffers() {
       // TODO - implement mapping
        throw new UnsupportedOperationException("Upcoming soon :)");
    }
}
