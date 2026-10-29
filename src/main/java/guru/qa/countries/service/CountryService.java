package guru.qa.countries.service;

import guru.qa.countries.domain.CountryResponse;
import guru.qa.countries.domain.UpdateCountryNameRequest;
import guru.qa.countries.domain.CreateCountryRequest;

import java.util.List;

public interface CountryService {

    List<CountryResponse> getAllCountries();

    CountryResponse getCountryByCode(String code);

    CountryResponse createCountry(CreateCountryRequest request);

    CountryResponse updateCountryName(String code, UpdateCountryNameRequest request);
}
