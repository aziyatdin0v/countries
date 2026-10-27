package guru.qa.countries.exception;

public class CountryAlreadyExistsException extends RuntimeException {
    public CountryAlreadyExistsException(String code) {
        super(String.format("Страна с кодом '%s' уже существует", code));
    }
}
