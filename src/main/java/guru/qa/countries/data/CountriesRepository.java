package guru.qa.countries.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;
import java.util.Optional;

public interface CountriesRepository extends JpaRepository<CountryEntity, UID> {
    boolean existsByCode(String code);

    Optional<CountryEntity> findByCode(String code);
}
