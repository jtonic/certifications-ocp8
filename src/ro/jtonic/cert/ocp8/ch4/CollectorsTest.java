package ro.jtonic.cert.ocp8.ch4;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

/**
 * Created by antonelpazargic on 09/05/16.
 */
public class CollectorsTest {

    public static void main(String... args) {
        final String[] names = {"tiger", "lion", "giraffe", "koala", "monkey"};
        Stream<String> animals = Stream.of(names);
        final Long animalCount = animals.collect(counting());
        System.out.println("animalCount = " + animalCount);

        animals = Stream.of(names);
        final String join1 = animals.collect(joining());
        System.out.println("Joining= " + join1);
        System.out.println("Joining1= " + Stream.of(names).collect(joining(", ")));

        System.out.println("Average of the names characters count: " + Stream.of(names).collect(averagingInt(String::length)));

        final IntSummaryStatistics ss = Stream.of(names).mapToInt(String::length).summaryStatistics();
        if (ss.getCount() == 0) {
            System.out.println("Empty stream");
        }
        final double average = ss.getAverage();
        System.out.println("Average computed with summaryStatistics: " + average);

        final List<String> animalsAsList = Stream.of(names).collect(toList());
        System.out.println("animalsAsList = " + animalsAsList);

        final Set<String> animalsAsATreeSet = Stream.of(names).collect(toCollection(TreeSet::new));
        System.out.println("animalsAsATreeSet = " + animalsAsATreeSet);

        System.out.println("MaxBy: " + Stream.of(names).collect(maxBy(Comparator.naturalOrder())));
        System.out.println("MinBy: " + Stream.of(names).collect(minBy(Comparator.reverseOrder())));

        System.out.println("Sum by the names characters numbers: " + Stream.of(names).collect(summingInt(String::length)));

        final Map<Integer, List<String>> groupByNoOfChars = Stream.of(names).collect(groupingBy(String::length));
        System.out.println("group1 = " + groupByNoOfChars);

        final TreeMap<Integer, Set<String>> group2 = Stream.of(names).collect(groupingBy(String::length, TreeMap::new,
                toCollection((Supplier<Set<String>>) () -> new TreeSet<>(Comparator.naturalOrder()))));
        System.out.println("group2 = " + group2);

        final Map<Integer, TreeSet<String>> group3 = Stream.of(names).collect(groupingBy(String::length, toCollection(TreeSet::new)));
        System.out.println("group3 = " + group3);

        final Map<Integer, Long> group4 = Stream.of(names).collect(groupingBy(String::length, counting()));
        System.out.println("group4 = " + group4);

        Map<Boolean, List<String>> part1 = Stream.of(names).collect(partitioningBy(s -> s.length() > 5));
        System.out.println("part1 = " + part1);
        Map<Boolean, Set<String>> part2 = Stream.of(names).collect(partitioningBy(s -> s.length() > 5, toCollection(TreeSet::new)));
        System.out.println("part2 = " + part2);

        Map<String, Integer> map1 = Stream.of(names).collect(toMap(Function.identity(), String::length));
        System.out.println("map1 = " + map1);

        // Map<Integer, String> map2 = Stream.of(names).collect(toMap(String::length, Function.identity()));
        // System.out.println("map2 = " + map2); //java.lang.IllegalStateException: Duplicate key tiger because of key duplication for 5

        // This solves the problem above through providing a merge implementation
        Map<Integer, String> map3 = Stream.of(names).collect(toMap(String::length, Function.identity(), (s1, s2) -> s1 + ", " + s2));
        System.out.println("map3 = " + map3);

        // moreover we can provide a TreeMap implementation
        Map<Integer, String> map4 = Stream.of(names).collect(toMap(String::length, Function.identity(), String::concat, TreeMap::new));
        System.out.println("map4 = " + map4);
    }

}
