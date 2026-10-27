package guru.qa.countries.controller;

import guru.qa.countries.domain.CountryResponse;
import guru.qa.countries.domain.UpdateCountryNameRequest;
import guru.qa.countries.domain.CreateCountryRequest;
import guru.qa.countries.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<CountryResponse> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{code}")
    public CountryResponse getCountryByCode(@PathVariable String code) {
        return countryService.getCountryByCode(code);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CountryResponse createCountry(@RequestBody CreateCountryRequest request) {
        return countryService.createCountry(request);
    }

    @PatchMapping("/{code}")
    public CountryResponse updateCountryName(@PathVariable String code, @RequestBody UpdateCountryNameRequest request) {
        return countryService.updateCountryName(code, request);
    }
}
