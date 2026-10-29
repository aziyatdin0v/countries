package guru.qa.countries.domain;

import java.util.UUID;

public record CountryResponse(UUID id, String code, String name) {
}
