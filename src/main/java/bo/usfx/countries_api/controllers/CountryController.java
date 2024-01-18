package bo.usfx.countries_api.controllers;

import bo.usfx.countries_api.models.Country;
import bo.usfx.countries_api.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/countries")
public final class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    /**
     * Gets information about a country by name or.
     *
     * @param filter Country name or id
     * @return ResponseEntity with country information if found, or empty ResponseEntity if not found.
     */
    @GetMapping("/{filter}")
    public ResponseEntity<?> getByNameOrId(@PathVariable final String filter) {
        Optional<Country> countryOptional = countryRepository.findByNameOrId(filter.toLowerCase(), filter);
        if (countryOptional.isPresent()) {
            Country country = countryOptional.get();
            return ResponseEntity.ok(country);
        } else {
            String errorMessage = "Name or Id no found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping
    public Country create(@RequestBody final Country country) {
        return countryRepository.save(country);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable final String id, @Validated @RequestBody final Country country) {
        Optional<Country> countryToUpdateOptional = countryRepository.findById(id);

        if (countryToUpdateOptional.isPresent()) {
            Country countryToUpdate = countryToUpdateOptional.get();
            countryToUpdate.setName(country.getName());
            countryToUpdate.setArea(country.getArea());
            countryToUpdate.setCapital(country.getCapital());
            countryToUpdate.setPopulation(country.getPopulation());
            countryToUpdate.setCities(country.getCities());
            countryToUpdate.setLanguages(country.getLanguages());
            countryToUpdate.setExtension(country.getExtension());
            countryToUpdate.setLatitude(country.getLatitude());
            countryToUpdate.setLongitude(country.getLongitude());
            countryToUpdate.setCurrency(country.getCurrency());
            countryToUpdate.setSecurityLevel(country.getSecurityLevel());
            countryToUpdate.setFlag(country.getFlag());
            countryToUpdate.setCodeCountry(country.getCodeCountry());
            countryToUpdate.setDemonym(country.getDemonym());
            countryToUpdate.setTypeOfWeather(country.getTypeOfWeather());
            countryToUpdate.setEconomy(country.getEconomy());
            countryRepository.save(countryToUpdate);
            return ResponseEntity.ok(countryToUpdate);
        } else {
            String errorMessage = "Id no found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable final String id) {
        Optional<Country> countryToDelete = countryRepository.findById(id);
        if (countryToDelete.isPresent()) {
            countryRepository.delete(countryToDelete.get());
            String successMessage = "Deleted Country with ID: " + id;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(successMessage);
        } else {
            String errorMessage = "Id no found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
}
