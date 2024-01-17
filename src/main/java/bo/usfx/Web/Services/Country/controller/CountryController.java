package bo.usfx.Web.Services.Country.controller;

import bo.usfx.Web.Services.Country.model.Country;
import bo.usfx.Web.Services.Country.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/countries")
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "api/v1/countries/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        var country = countryRepository.findById(id);
        if (country.isPresent()) {
            return ResponseEntity.ok(country.get());
        }
        return ResponseEntity.notFound().build();
    }

}
