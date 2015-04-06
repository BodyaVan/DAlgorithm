package ua.kpi.dalgorithm.automate;

import ua.kpi.dalgorithm.exceptions.FixedSizeException;

import java.util.*;
import java.util.function.Supplier;

import static ua.kpi.dalgorithm.exceptions.ExceptionMessages.*;
import static ua.kpi.dalgorithm.util.ListUtils.createFixedSizeConstructedList;

/**
 * Created on 01.04.2015
 *
 * @author Bohdan Vanchuhov
 */
public class NamedList<T> implements Iterable<T> {
    protected List<T> items = new ArrayList<>();
    protected Map<String, Integer> nameIndexMap = new HashMap<>();

    protected boolean isFixedSize = false;
    protected NameGenerator nameGenerator;
    private Supplier<T> defaultItemFactory = () -> null;

    public NamedList() {
    }

    public NamedList(Supplier<T> defaultItemFactory, NameGenerator nameGenerator) {
        this.defaultItemFactory = defaultItemFactory;
        this.nameGenerator = nameGenerator;
    }

    public NamedList<T> setDefaultItemFactory(Supplier<T> defaultItemFactory) {
        this.defaultItemFactory = defaultItemFactory;
        return this;
    }

    public NamedList<T> setNameGenerator(NameGenerator nameGenerator) {
        this.nameGenerator = nameGenerator;
        return this;
    }

    public int getSize() {
        return items.size();
    }

    public NamedList<T> setSize(int size) {
        items = createFixedSizeConstructedList(size, defaultItemFactory);
        isFixedSize = true;
        return this;
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

    //--------------------------------------------------

    protected void add0(T item) {
        items.add(item);
    }

    protected void afterAdd(T item, int index, String itemName) {
    }

    public NamedList<T> add(T item) {
        add0(item);

        int index = getLastItemIndex();
        String itemName = nameGenerator.generateName(index);
        setName(index, itemName);

        afterAdd(item, index, itemName);

        return this;
    }

    public NamedList<T> add(T item, String itemName) {
        checkNameNotExists(itemName);

        add0(item);

        int index = getLastItemIndex();
        setName(index, itemName);

        afterAdd(item, index, itemName);

        return this;
    }

    //--------------------------------------------------

    protected void afterSetName(T item, String name) {
    }

    public NamedList<T> setName(int index, String name) {
        checkIndex(index);
        checkNameNotExists(name);

        nameIndexMap.put(name, index);
        afterSetName(get(index), name);

        return this;
    }

    public int getLastItemIndex() {
        if (isFixedSize) {
            throw new FixedSizeException("Get last item index operation is not supported");
        }
        return items.size() - 1;
    }

    //--------------------------------------------------

    protected void set0(int index, T item) {
        items.set(index, item);
    }

    protected void afterSet(int index, String name, T item) {
    }

    public NamedList<T> set(int index, T item) {
        set0(index, item);

        String itemName = nameGenerator.generateName(index);
        setName(index, itemName);

        afterSet(index, itemName, item);

        return this;
    }

    public NamedList<T> set(String name, T item) {
        checkNameExists(name);

        Integer index = nameIndexMap.get(name);
        set0(index, item);

        afterSet(index, name, item);

        return this;
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

    public List<T> getItems() {
        return items;
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (int i = 0, last = getSize(); i < last; i++) {
            final int index = i;
            String name = nameIndexMap.entrySet().stream()
                    .filter(entry -> entry.getValue() == index)
                    .map(entry -> entry.getKey())
                    .findFirst().get();
            names.add(name);
        }
        return names;
    }
}
