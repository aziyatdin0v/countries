package guru.qa.countries.exception;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(String code) {
        super(String.format("Страна с кодом '%s' не найдена", code));
    }
}
