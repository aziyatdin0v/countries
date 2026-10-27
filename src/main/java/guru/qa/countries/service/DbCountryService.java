package guru.qa.countries.service;

import guru.qa.countries.data.CountriesRepository;
import guru.qa.countries.data.CountryEntity;
import guru.qa.countries.domain.CountryResponse;
import guru.qa.countries.domain.UpdateCountryNameRequest;
import guru.qa.countries.domain.CreateCountryRequest;
import guru.qa.countries.exception.CountryAlreadyExistsException;
import guru.qa.countries.exception.CountryNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbCountryService implements CountryService {

    private final CountriesRepository countriesRepository;

    public DbCountryService(CountriesRepository countriesRepository) {
        this.countriesRepository = countriesRepository;
    }

    @Override
    public List<CountryResponse> getAllCountries() {
        return countriesRepository.findAll()
                .stream()
                .map(this::toCountryResponse)
                .toList();
    }

    @Override
    public CountryResponse getCountryByCode(String code) {
        return countriesRepository.findByCode(code)
                .map(this::toCountryResponse)
                .orElseThrow(() -> new CountryNotFoundException(code));
    }

    @Override
    @Transactional
    public CountryResponse createCountry(CreateCountryRequest request) {
        if (countriesRepository.existsByCode(request.code())) {
            throw new CountryAlreadyExistsException(request.code());
        }

        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setCode(request.code());
        countryEntity.setName(request.name());
        return toCountryResponse(countriesRepository.save(countryEntity));
    }

    @Override
    @Transactional
    public CountryResponse updateCountryName(String code, UpdateCountryNameRequest request) {
        CountryEntity countryEntity = countriesRepository
                .findByCode(code)
                .orElseThrow(() -> new CountryNotFoundException(code));

        countryEntity.setName(request.name());
        return toCountryResponse(countriesRepository.save(countryEntity));
    }

    private CountryResponse toCountryResponse(CountryEntity entity) {
        return new CountryResponse(entity.getId(), entity.getCode(), entity.getName());
    }
}
