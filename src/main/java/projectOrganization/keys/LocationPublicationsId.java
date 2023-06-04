package projectOrganization.keys;

import java.io.Serializable;

public class LocationPublicationsId implements Serializable {
    private Integer id_publication;
    private Integer id_shelving;
    private Integer num_shelf;

    public LocationPublicationsId() {};

    public LocationPublicationsId(Integer id_publication, Integer id_shelving, Integer num_shelf) {
        this.id_publication = id_publication;
        this.id_shelving = id_shelving;
        this.num_shelf = num_shelf;
    }
}
