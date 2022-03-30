package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("B", 0),
                new Job("A", 1)
        );
        Comparator<Job> cmpPriorityName = new JobAscByPriority().thenComparing(new JobAscByName());
        Collections.sort(jobs, cmpPriorityName);
        int rsl = cmpPriorityName.compare(jobs.get(0), jobs.get(1));
        System.out.println(rsl);
    }
}