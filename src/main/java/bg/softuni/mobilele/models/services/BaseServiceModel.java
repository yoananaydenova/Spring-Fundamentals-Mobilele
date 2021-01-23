package bg.softuni.mobilele.models.services;

import javax.persistence.Column;
import java.time.Instant;

public abstract class BaseServiceModel {

    protected Long id;
    protected Instant created;
    protected Instant modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }
}
