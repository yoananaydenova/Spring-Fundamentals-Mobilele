package bg.softuni.mobilele.services;

import bg.softuni.mobilele.models.services.OfferServiceModel;
import bg.softuni.mobilele.models.views.OfferSummaryViewModel;

import java.util.List;

public interface OfferService {

    List<OfferSummaryViewModel> getAllOffers();

    Long save(OfferServiceModel offerServiceModel);

    void delete(Long id);
}
