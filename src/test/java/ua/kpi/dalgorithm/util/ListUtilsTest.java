package ua.kpi.dalgorithm.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.nullValue;
import static ua.kpi.dalgorithm.util.ListUtils.*;

public class ListUtilsTest {
    @Test
    public void crateConstructedStringArrayList_3argsMethod() throws Exception {
        List<String> list = createConstructedList(5, ArrayList::new, String::new);

        assertThat(list, hasItems("", "", "", "", ""));
    }

    @Test
    public void crateConstructedStringArrayList_2argsMethod() throws Exception {
        List<String> list = ListUtils.createConstructedList(5, String::new);

        assertThat(list, hasItems("", "", "", "", ""));
    }

    //--------------------------------------------------

    @Test
    public void createFilledIntegerArrayList_3argsMethod() throws Exception {
        List<Integer> list = createFilledList(5, ArrayList::new, Integer.valueOf(1));

        assertThat(list, hasItems(1, 1, 1, 1));
    }

    @Test
    public void createFilledNullArrayList_3argsMethod() throws Exception {
        List<Integer> list = createFilledList(5, ArrayList::new, null);

        assertThat(list, hasItems(nullValue(), nullValue(), nullValue(), nullValue(), nullValue()));
    }

    //--------------------------------------------------


    @Test
    public void testUnion() throws Exception {
        List<String> list = union(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d")
        );

        assertThat(list, hasItems("a", "b", "c", "d"));
    }
}
