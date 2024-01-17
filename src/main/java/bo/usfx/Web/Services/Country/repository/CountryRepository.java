package bo.usfx.Web.Services.Country.repository;

import bo.usfx.Web.Services.Country.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepository extends MongoRepository<Country, String> {
}
