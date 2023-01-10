package br.com.homework.superheroes.services;

public abstract class AbstractValidateService<T> {

    protected abstract boolean validate(T t);

    protected boolean validateStringIsNullOrBlank(String value){
        return value.isBlank();
    }

    protected boolean validateLongNotZero(Long value){
        return value != 0;
    }
}
