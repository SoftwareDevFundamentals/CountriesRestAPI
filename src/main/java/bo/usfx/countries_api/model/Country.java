package bo.usfx.countries_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "countries")
public final class Country {

    @Id
    private String id;
    private String name;
    private Integer population;

    // Obtiene id del pais
    public String getId() {
        return id;
    }

    // Establece el id del pais
    public void setId(final String id) {
        this.id = id;
    }

    // Obtiene el nombre del pais
    public String getName() {
        return name;
    }

    // Establece el nombre del pais
    public void setName(final String name) {
        this.name = name;
    }

    // Obtiene la poblacion del pais
    public Integer getPopulation() {
        return population;
    }

    // Establece la poblacion del pais
    public void setPopulation(final Integer population) {
        this.population = population;
    }
}