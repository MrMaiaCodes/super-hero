package br.com.homework.superheroes.service;

public abstract class AbstractValidateService<T> {

    protected abstract boolean validate(T t);

    protected boolean validateStringIsNullOrBlank(String value){
        return value.isBlank();
    }

    protected boolean validateIntNotZero(int value){
        return value != 0;
    }
}
