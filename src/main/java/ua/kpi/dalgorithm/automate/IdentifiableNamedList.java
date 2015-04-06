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

    public IdentifiableNamedList(Supplier<T> defaultItemFactory, NameGenerator nameGenerator) {
        super(defaultItemFactory, nameGenerator);
    }

    @Override
    protected void afterAdd(T item, int index, String itemName) {
        super.afterAdd(item, index, itemName);

        item.setIndex(index);
        item.setName(itemName);
    }

    @Override
    protected void afterSetName(T item, String name) {
        super.afterSetName(item, name);

        item.setName(name);
    }

    @Override
    protected void afterSet(int index, String indexName, T item) {
        super.afterSet(index, indexName, item);

        item.setIndex(index);
        item.setName(indexName);
    }

    @Override
    public List<String> getNames() {
        return createNamesList(items);
    }
}
