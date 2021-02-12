package bg.softuni.mobilele.web;

import bg.softuni.mobilele.models.entities.enums.EngineEnum;
import bg.softuni.mobilele.models.entities.enums.TransmissionEnum;
import bg.softuni.mobilele.models.services.OfferServiceModel;
import bg.softuni.mobilele.services.BrandService;
import bg.softuni.mobilele.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private final OfferService offerService;
    private final BrandService brandService;

    @Autowired
    public OffersController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @ModelAttribute("offerServiceModel")
    public OfferServiceModel offerModel() {
        return new OfferServiceModel();
    }


    @GetMapping("/add")
    public String newOffer(Model model) {
        model.addAttribute("brands", brandService.getAllBrands());
        model.addAttribute("engines", EngineEnum.values());
        model.addAttribute("transmissions", TransmissionEnum.values());
        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(@Valid @ModelAttribute OfferServiceModel offerServiceModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerServiceModel", offerServiceModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerServiceModel", bindingResult);
            return "redirect:/offers/add";
        }

        Long newOfferId = offerService.save(offerServiceModel);
        return "redirect:/offers/offer/" + newOfferId;
    }

    @GetMapping("/offer/{id}")
    public String offerDetails(@PathVariable String id,
                               Model model) {

        model.addAttribute("id", id);

        return "details";
    }

    @DeleteMapping("/offer/{id}")
    public String delete(@PathVariable Long id,
                         Model model) {

        offerService.delete(id);

        return "redirect:/offers/all";
    }

    @GetMapping("/all")
    public String getAllOffers(Model model) {
        //TODO:
        //model.addAttribute("models", offerService.getAllOffers());
        return "offers";
    }


}
