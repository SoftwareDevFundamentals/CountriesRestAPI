package bo.usfx.countries_api.repository;

import bo.usfx.countries_api.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepository extends MongoRepository<Country, String> {
}
