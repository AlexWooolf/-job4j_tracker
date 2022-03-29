package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.collection.NotifyAccount;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemAscByNameTest extends TestCase {

    @Test
    public void testCompare() {
        List<Item> items = Arrays.asList(new Item("A"), new Item("Z"), new Item("C"));
        Comparator asc = new ItemAscByName();
        Collections.sort(items, asc);
        List<Item> expected = Arrays.asList(new Item("A"), new Item("C"), new Item("Z"));
        assertThat(items.toString(), is(expected.toString()));
    }
}