package ua.kpi.dalgorithm.automate;

import ua.kpi.dalgorithm.logic_component.Identifiable;

import java.util.List;
import java.util.function.Supplier;

import static ua.kpi.dalgorithm.util.ListUtils.createNamesList;

/**
 * Created on 05.04.2015
 *
 * @author Bohdan Vanchuhov
 */
public class IdentifiableNamedList<T extends Identifiable> extends NamedList<T> {
    public IdentifiableNamedList() {
    }

    public IdentifiableNamedList(Supplier<T> defaultItemFactory) {
        super(defaultItemFactory);
    }

    @Override
    public NamedList<T> add(T item) {
        super.add(item);
        setIndexInItem(item, getLastItemIndex());

        return this;
    }

    @Override
    public NamedList<T> set(int index, T item) {
        super.set(index, item);
        setIndexInItem(item, index);

        return this;
    }

    private void setIndexInItem(T item, int index) {
        item.setIndex(index);
    }

    @Override
    public NamedList<T> setName(int index, String name) {
        super.setName(index, name);

        T item = get(index);
        item.setName(name);

        return this;
    }

    @Override
    public List<String> getNames() {
        return createNamesList(items);
    }
}
