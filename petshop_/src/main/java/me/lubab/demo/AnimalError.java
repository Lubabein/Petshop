package me.lubab.demo;

public class AnimalError extends Exception {
    public AnimalError(long id) {
        super(String.format("id %s ", id));
    }
}

