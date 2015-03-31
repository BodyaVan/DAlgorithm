package ua.kpi.dalgorithm.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created on 10.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public final class ListUtils {
    private ListUtils() {
    }

    public static <E> List<E> createConstructedList(int size, Supplier<List<E>> listFactory, Supplier<E> itemFactory) {
        List<E> resultList = listFactory.get();

        for (int i = 0; i < size; i++) {
            E item = itemFactory.get();
            resultList.add(item);
        }

        return resultList;
    }

    public static <E> List<E> createConstructedList(int size, Supplier<E> itemFactory) {
        return createConstructedList(size, ArrayList::new, itemFactory);
    }

    public static <E> List<E> createFilledList(int size, Supplier<List<E>> listFactory, E filler) {
        List<E> resultList = listFactory.get();

        for (int i = 0; i < size; i++) {
            resultList.add(filler);
        }

        return resultList;
    }

    public static <E> List<E> createFilledList(int size, E filler) {
        return createFilledList(size, ArrayList::new, filler);
    }
}
