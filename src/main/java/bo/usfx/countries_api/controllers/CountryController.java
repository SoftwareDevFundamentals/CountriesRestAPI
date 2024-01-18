package bo.usfx.countries_api.controllers;

import bo.usfx.countries_api.models.Country;
import bo.usfx.countries_api.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public final class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping(method = RequestMethod.GET, value = "api/v1/countries")
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    /**
     * Gets information about a country by name or.
     * @param filter Country name or id
     * @return ResponseEntity with country information if found, or empty ResponseEntity if not found.
     */
    @RequestMapping(method = RequestMethod.GET, value = "api/v1/countries/{filter}")
    public ResponseEntity<?> getByNameOrId(@PathVariable final String filter) {
        Optional<Country> country = countryRepository.findByNameOrId(filter, filter);
        if (country.isPresent()) {
            return ResponseEntity.ok(country);
        }
        return ResponseEntity.ok().build();
    }

    /*@RequestMapping(method = RequestMethod.POST, value = "api/v1/countries")
    public ResponseEntity<?> create(@RequestBody final Country country) {
        var countryCreated = countryRepository.save(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(countryCreated);
    }*/

    @RequestMapping(method = RequestMethod.POST, value = "api/v1/countries")
    public ResponseEntity<?> create(@RequestBody final Country country) {
        Optional<Country> existingCountry = countryRepository.findByNameOrId(country.getName(), country.getId());
        if(existingCountry.isPresent()) {
            //Si existe devolvemos mensaje
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", 400);
            errorResponse.put("message", "El pais con el mismo nombre o identificador ya ha sido creado");

            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        //Si el pais no existe lo guardamos
        var countryCreated = countryRepository.save(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(countryCreated);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "api/v1/countries/{id}")
    public ResponseEntity<?> update(@PathVariable final String id, @RequestBody final Country country) {
        Country countryToUpdate = countryRepository.findById(id).orElse(null);

        if (countryToUpdate != null) {
            countryToUpdate.setName(country.getName());
            countryToUpdate.setCapital(country.getCapital());
            countryToUpdate.setPopulation(country.getPopulation());
            countryToUpdate.setArea(country.getArea());
            countryToUpdate.setCurrency(country.getCurrency());
            countryToUpdate.setLanguages(country.getLanguages());
            countryToUpdate.setFlag(country.getFlag());

            countryRepository.save(countryToUpdate);

            return ResponseEntity.ok(countryToUpdate);
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", 404);
            errorResponse.put("message", "No se encontró un país con el ID especificado: " + id);

            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "api/v1/countries/{id}")
    public ResponseEntity<?> delete(@PathVariable final String id) {
        Country countryToDelete = countryRepository.findById(id).orElse(null);

        if (countryToDelete != null) {
            countryRepository.delete(countryToDelete);

            Map<String, Object> successResponse = new HashMap<>();
            successResponse.put("message", "Se eliminó el país con el ID especificado: " + id);

            return ResponseEntity.ok(successResponse);
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", 404);
            errorResponse.put("message", "No se encontró un país con el ID especificado: " + id);

            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }
}
