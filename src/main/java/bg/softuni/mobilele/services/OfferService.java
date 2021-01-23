package bg.softuni.mobilele.services;

import bg.softuni.mobilele.models.views.OfferSummaryViewModel;

import java.util.List;

public interface OfferService {

    List<OfferSummaryViewModel> getAllOffers();
}
