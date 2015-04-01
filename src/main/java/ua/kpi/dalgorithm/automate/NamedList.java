package ua.kpi.dalgorithm.automate;

import ua.kpi.dalgorithm.exceptions.FixedSizeException;
import ua.kpi.dalgorithm.logic_component.Indexable;
import ua.kpi.dalgorithm.util.ListUtils;

import java.util.*;
import java.util.function.Supplier;

import static ua.kpi.dalgorithm.exceptions.ExceptionMessages.*;

/**
 * Created on 01.04.2015
 *
 * @author Bohdan Vanchuhov
 */
public class NamedList<T extends Indexable> implements Iterable<T> {
    private List<T> items = new ArrayList<>();
    private Map<String, Integer> nameIndexMap = new HashMap<>();
    private Supplier<T> defaultItemFactory = () -> null;
    private boolean isFixedSize = false;

    public NamedList() {
    }

    public NamedList(Supplier<T> defaultItemFactory) {
        this.defaultItemFactory = defaultItemFactory;
    }

    public int getSize() {
        return items.size();
    }

    public void setSize(int size) {
        items = org.apache.commons.collections4.ListUtils.fixedSizeList(
                ListUtils.createConstructedList(size, defaultItemFactory));
        isFixedSize = true;
    }

    public T get(int index) {
        checkIndex(index);

        return items.get(index);
    }

    private void checkIndex(int index) {
        if (index < 0 || index > items.size()) {
            throw new IllegalArgumentException(
                    String.format(ILLEGAL_INDEX_TEMPLATE, items.size() - 1, index));
        }
    }

    public T get(String name) {
        checkNameExists(name);

        Integer index = nameIndexMap.get(name);
        return items.get(index);
    }

    private void checkNameExists(String name) {
        if (!nameIndexMap.containsKey(name)) {
            throw new IllegalArgumentException(String.format(NAME_NOT_EXISTS_TEMPLATE, name));
        }
    }

    public int getIndexByName(String name) {
        checkNameExists(name);

        return nameIndexMap.get(name);
    }

    public NamedList<T> add(T item) {
        items.add(item);
        setIndexInItem(item, getLastItemIndex());

        return this;
    }

    private void setIndexInItem(T item, int index) {
        item.setIndex(index);
    }

    public NamedList<T> add(T item, String itemName) {
        checkNameNotExists(itemName);

        add(item);
        setName(getLastItemIndex(), itemName);

        return this;
    }

    public NamedList<T> setName(int index, String name) {
        checkIndex(index);
        checkNameNotExists(name);

        nameIndexMap.put(name, index);

        return this;
    }

    public int getLastItemIndex() {
        if (isFixedSize) {
            throw new FixedSizeException("Get last item index operation is not supported");
        }
        return items.size() - 1;
    }

    public NamedList<T> set(int index, T item) {
        items.set(index, item);
        setIndexInItem(item, index);

        return this;
    }

    public NamedList<T> set(String name, T item) {
        checkNameExists(name);

        Integer index = nameIndexMap.get(name);
        return set(index, item);
    }

    private void checkNameNotExists(String name) {
        if (nameIndexMap.containsKey(name)) {
            throw new IllegalArgumentException(String.format(NAME_EXISTS_TEMPLATE, name));
        }
    }

    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
