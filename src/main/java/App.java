import model.*;
import repositories.PeronRepositoryImpl;
import repositories.PersonRepository;

import java.time.Period;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class App {


    public static void main(String[] args) {

        PeronRepositoryImpl peronRepository = new PeronRepositoryImpl();
        List<Person> personList = Arrays.asList(
                new Person("Вит", "Dbn", 41, "rus"),
                new Person("DDD", "FFF", 18, "Ang"),
                new Person("JJJ", "KKKK", 35, "UZ"));
        peronRepository.createPerson(personList);

        List<Person> personListTwo = Arrays.asList(
                new Person("Бит", "Dbn", 41, "rus"),
                new Person("ЛDD", "FFF", 18, "Ang"),
                new Person("ЕJ", "KKKK", 35, "UZ"));

        System.out.println();

        Set<String> national = personList.stream()
                .filter(person -> person.getFirstName().startsWith("В"))
                .map(Person::getNationality)
                .collect(Collectors.toSet());
        System.out.println(national);

        Set<String> nameLenght =
                personListTwo.stream()
                        .filter(person -> person.getFirstName().length() > 2)
                        .map(person -> person.getLastName())
                        .collect(Collectors.toSet());
        System.out.println(nameLenght);

        Set<String> pesonMap = personListTwo.stream()
                .map(person -> person.getNationality())
                .collect(Collectors.toSet());
        System.out.println(pesonMap);
        personListTwo.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getFirstName))
                        .forEach(System.out::println);

        Integer sss = personListTwo.stream()
                .map(person -> person.getAge())
                .min(Integer::compareTo)
                .get();
        System.out.println(sss);

       List<String> newPerson = personListTwo.stream()
                .flatMap(person -> Stream.of(person.getFirstName(),person.getLastName()))
               .peek(x-> System.out.printf("%-5s", x))
//               .peek(x->System.out.println);
//               .forEach(System.out::println);
                .collect(Collectors.toList());
        System.out.println("\n" + newPerson);

        String combi = personListTwo.stream()
                .flatMap(person -> Stream.of(person.getFirstName(), person.getNationality()))
                .collect(Collectors.joining(", ","[","]"));
        System.out.println(combi);

        Optional<Person> pp = personListTwo.stream()
                .collect(maxBy(Comparator.comparing(Person::getAge)));
        System.out.println(pp);

        Map<Integer, List<Person>> ps =personListTwo.stream()
//                .map(person -> person.getNationality())
                .collect(groupingBy(Person::getAge));
        System.out.println(ps);

        Preobrazovanie<Integer> nums = x->x%13==0;
        System.out.println(nums.test(3));

                Stroka ff = (s1,s2)-> s1.length()>=s2.length() ? s1:s2;
        System.out.println(ff.apply("sssss","dddddddd"));



        NumberDrob numAll= numsW->new TreeNum(numsW.a()* numsW.a(), numsW.b()* numsW.b(), numsW.c()* numsW.c());

        TreeNum resDr = numAll.apply(new TreeNum(2.0,5.0,7.0));
        System.out.println(resDr);

//        NumberDrob num33 = (n1,n2,n3)-> new double[]{n1 * n1, n2 * n2, n3 * n3};
//        double[] res = num33.apply(2.0,4.0,6.0);
//        System.out.println(Arrays.toString(res));





//        System.out.println(nameShort);


        List<Person> allPerson = Stream.of(personList, personListTwo)

                .flatMap(Collection::stream)
                .toList();
//        System.out.println(allPerson);

        List<Integer> th = Stream.of(List.of(1, 2, 3), List.of(4, 5, 6))
                .flatMap(Collection::stream)
                .toList();
//        System.out.println(th);

        Integer minTh = th.stream()
                .max(Comparator.comparing(num -> num))
//                .get()
                .orElseThrow();


//                .get();
//        System.out.println(minTh);


    }
}
