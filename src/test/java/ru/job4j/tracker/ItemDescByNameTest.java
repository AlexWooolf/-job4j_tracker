package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemDescByNameTest extends TestCase {

    @Test
    public void testCompare() {
        List<Item> items = Arrays.asList(new Item("A"), new Item("Z"), new Item("C"));
        Comparator desc = new ItemDescByName();
        Collections.sort(items, desc);
        List<Item> expected = Arrays.asList(new Item("Z"), new Item("C"), new Item("A"));
        assertThat(items.toString(), is(expected.toString()));
    }
}