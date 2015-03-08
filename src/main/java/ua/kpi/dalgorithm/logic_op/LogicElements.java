package ua.kpi.dalgorithm.logic_op;

/**
 * Created on 07.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public final class LogicElements {
    public static final LogicOperation AND = new AndOperation();
    public static final LogicOperation OR = new OrOperation();
    public static final LogicOperation NOT_AND = new NotAndOperation();
    public static final LogicOperation NOT_OR = new NotOrOperation();

    private LogicElements() {
    }
}
