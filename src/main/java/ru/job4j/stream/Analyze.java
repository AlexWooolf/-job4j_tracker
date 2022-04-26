package ru.job4j.stream;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.
                flatMapToInt(pupil -> pupil.getSubjects().stream().mapToInt(Subject::getScore)).
                average().
                getAsDouble();
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.
                map((pupil) -> new Tuple(pupil.getName(), pupil.getSubjects().
                        stream().mapToInt(Subject::getScore).
                        average().getAsDouble())).
                collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.
                flatMap(pupil -> pupil.getSubjects().
                        stream().
                        collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new, Collectors.averagingDouble(Subject::getScore))).
                        entrySet().
                        stream().map(s -> new Tuple(s.getKey(), s.getValue()))).
                collect(Collectors.toList());

    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.
                map((pupil) -> new Tuple(pupil.getName(), pupil.getSubjects().
                        stream().mapToInt(Subject::getScore).
                        sum())).max(Tuple::compareTo).get();
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.
                flatMap(pupil -> pupil.getSubjects().
                        stream().
                        collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new, Collectors.summingDouble(Subject::getScore))).
                        entrySet().
                        stream().map(s -> new Tuple(s.getKey(), s.getValue()))).
                max(Tuple::compareTo).get();

    }

    public static void main(String[] args) {
        List<Tuple> average = Analyze.averageScoreByPupil(
                List.of(
                        new Pupil("Ivanov",
                                List.of(
                                        new Subject("Math", 100),
                                        new Subject("Lang", 100),
                                        new Subject("Philosophy", 100)
                                )
                        ),
                        new Pupil("Petrov",
                                List.of(
                                        new Subject("Math", 60),
                                        new Subject("Lang", 60),
                                        new Subject("Philosophy", 60)
                                )
                        )
                ).stream()
        );
        average.stream().map(Tuple::toString).forEach(System.out::println);
    }
}