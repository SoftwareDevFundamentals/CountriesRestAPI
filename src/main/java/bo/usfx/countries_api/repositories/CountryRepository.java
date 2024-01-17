package bo.usfx.countries_api.repositories;

import bo.usfx.countries_api.models.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepository extends MongoRepository<Country, String> {
    Country findByName(String name);
}
