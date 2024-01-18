package bo.usfx.countries_api.repositories;

import bo.usfx.countries_api.models.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CountryRepository extends MongoRepository<Country, String> {
    @Query("{$or: [ {'name': {$regex: ?0, $options: 'i'}}, {'_id': ?1} ]}")
    Optional<Country> findByNameOrId(String name, String id);
}
