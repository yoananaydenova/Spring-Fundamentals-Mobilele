package bg.softuni.mobilele.init;

import bg.softuni.mobilele.models.entities.BaseEntity;
import bg.softuni.mobilele.models.entities.BrandEntity;
import bg.softuni.mobilele.models.entities.ModelEntity;
import bg.softuni.mobilele.models.entities.enums.ModelCategoryEnum;
import bg.softuni.mobilele.repositories.BrandRepository;
import bg.softuni.mobilele.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public  DataInitializer(ModelRepository modelRepository, BrandRepository brandRepository){
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        BrandEntity fordBrand = new BrandEntity();
        fordBrand.setName("Ford");
        setCurrentTimesStamps(fordBrand);

        BrandEntity hondaBrand = new BrandEntity();
        hondaBrand.setName("Honda");
        setCurrentTimesStamps(hondaBrand);

        brandRepository.saveAll(List.of(fordBrand, hondaBrand));

        initFiesta(fordBrand);
        initEscort(fordBrand);
        initNC750S(hondaBrand);
    }

    private ModelEntity initNC750S(BrandEntity hondaBrand){
        ModelEntity nc750s = new ModelEntity();
        nc750s.setName("NC750S");
        nc750s.setCategory(ModelCategoryEnum.MOTORCYCLE);
        nc750s.setImageUrl("https://www.mitchellsmc.co.uk/wp-content/uploads/2020/07/IMG_0686.jpg");
        nc750s.setStartYear(2014);
        nc750s.setBrand(hondaBrand);

        setCurrentTimesStamps(nc750s);

        return this.modelRepository.save(nc750s);
    }

    private  ModelEntity initFiesta(BrandEntity fordBrand) {
        ModelEntity fiesta = new ModelEntity();
        fiesta.setName("Fiesta");
        fiesta.setCategory(ModelCategoryEnum.CAR);
        fiesta.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/413px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg");
        fiesta.setStartYear(1976);
        fiesta.setBrand(fordBrand);

        setCurrentTimesStamps(fiesta);

        return this.modelRepository.save(fiesta);
    }

    private  ModelEntity initEscort(BrandEntity fordBrand) {

        ModelEntity eskort = new ModelEntity();
        eskort.setName("Escort");
        eskort.setCategory(ModelCategoryEnum.CAR);
        eskort.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Ford_Escort_3_by_seaside.jpg/413px-Ford_Escort_3_by_seaside.jpg");
        eskort.setStartYear(1968);
        eskort.setEndYear(2002);
        eskort.setBrand(fordBrand);

        setCurrentTimesStamps(eskort);

        return this.modelRepository.save(eskort);
    }

    private static void setCurrentTimesStamps(BaseEntity baseEntity){
        baseEntity.setCreated(Instant.now());
        baseEntity.setModified(Instant.now());
    }
}
