package ua.kpi.dalgorithm.util;

import ua.kpi.dalgorithm.logic_component.Nameable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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
        return createConstructedList(size, listFactory, () -> filler);
    }

    public static <E> List<E> createFilledList(int size, E filler) {
        return createFilledList(size, ArrayList::new, filler);
    }

    public static <E> List<E> createFixedSizeConstructedList(int size, Supplier<E> itemFactory) {
        return org.apache.commons.collections4.ListUtils.fixedSizeList(createConstructedList(size, itemFactory));
    }

    public static <E> List<E> createFixedSizeFilledList(int size, E filler) {
        return org.apache.commons.collections4.ListUtils.fixedSizeList(createFilledList(size, filler));
    }

    public static <E extends Nameable> List<String> createNamesList(List<E> list) {
        return list.stream()
                .map(element -> element.getName())
                .collect(Collectors.toList());
    }

    public static <E> List<E> union(List<E>... lists) {
        List<E> resultList = new ArrayList<>();

        for (List<E> list : lists) {
            resultList = org.apache.commons.collections4.ListUtils.sum(resultList, list);
        }

        return resultList;
    }
}
