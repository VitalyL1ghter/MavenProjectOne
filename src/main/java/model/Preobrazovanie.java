package model;

@FunctionalInterface
public interface Preobrazovanie<T> {
    boolean test (T t);

}
