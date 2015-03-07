package ua.kpi.dalgorithm.logic_elem;

/**
 * Created on 07.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public final class LogicElements {
    private LogicElements() {}

    public static final LogicElement AND = new AndElement();
    public static final LogicElement OR = new OrElement();
}
