package bg.softuni.mobilele.models.services;

import bg.softuni.mobilele.models.entities.enums.EngineEnum;
import bg.softuni.mobilele.models.entities.enums.TransmissionEnum;
import bg.softuni.mobilele.models.validation.YearInPastOrPresent;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class OfferServiceModel  {

    private EngineEnum engine;
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;
    @YearInPastOrPresent(minYear = 1930)
    private Integer year;
    private String description;
    private TransmissionEnum transmission;
    private Long modelId;

    public OfferServiceModel() {
    }

    @NotNull
    public EngineEnum getEngine() {
        return engine;
    }

    public OfferServiceModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    @NotEmpty
    public String getImageUrl() {
        return imageUrl;
    }

    public OfferServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @NotNull
    @PositiveOrZero
    public Integer getMileage() {
        return mileage;
    }

    public OfferServiceModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    @NotNull
    @DecimalMin(value = "100")
    public BigDecimal getPrice() {
        return price;
    }

    public OfferServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferServiceModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    @NotEmpty
    @Size(min=10, max=512)
    public String getDescription() {
        return description;
    }

    public OfferServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotNull
    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferServiceModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    @NotNull
    public Long getModelId() {
        return modelId;
    }

    public OfferServiceModel setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    @Override
    public String toString() {
        return "OfferServiceModel{" +
                "engine=" + engine +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", transmission=" + transmission +
                ", modelId=" + modelId +
                '}';
    }
}
