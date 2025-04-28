package repositories;

import model.Person;

import java.util.List;
import java.util.stream.Stream;

public class PeronRepositoryImpl implements PersonRepository {


    @Override
    public void createPerson(List<Person> person) {
        Stream<Person> personStream = person.stream();
        personStream.forEach(System.out::println);
    }
}
