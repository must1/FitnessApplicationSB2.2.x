package main.validator.attributes;

public interface Validator<T> {

    String validate(T value);
}
